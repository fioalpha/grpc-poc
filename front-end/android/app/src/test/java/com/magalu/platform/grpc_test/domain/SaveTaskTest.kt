package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.model.Task
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import junit.framework.TestCase

import org.junit.Assert.*
import org.junit.Test

class SaveTaskTest {

    private val repository = mockk<Repository>()

    private val saveTask = SaveTaskImpl(repository)

    @Test
    fun `save task With success to Return task` (){
        val taskMock = Task(12, "TEST", "TEST", "2020")
        every { repository.saveTask(taskMock) } returns Single.just(taskMock)
        saveTask.saveTask(taskMock)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue { it == taskMock }
    }

    @Test
    fun `save task With error to Return Exception` (){
        val taskMock = Task(12, "TEST", "TEST", "2020")
        val throwable = Throwable()
        every { repository.saveTask(taskMock) } returns Single.error(throwable)
        saveTask.saveTask(taskMock)
            .test()
            .assertError { it == throwable }
    }

}