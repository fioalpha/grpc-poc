package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.model.Task
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import junit.framework.TestCase

import org.junit.Assert.*
import org.junit.Test

class DeleteTaskTest {
    private val repositoryMock = mockk<Repository>()

    private val deleteTask = DeleteTaskImpl(repositoryMock)

    @Test
    fun `delete task With success Return Task` () {
        val task = Task(1, "TEST", "TEST", "2020-10-01")
        every { repositoryMock.deleteTask(task) } returns Single.just(task)
        deleteTask.delete(task)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                it == task
            }
    }

    @Test
    fun `delete task With error Return Exception` () {
        val task = Task(1, "TEST", "TEST", "2020-10-01")
        val exception = Exception()
        every { repositoryMock.deleteTask(task) } returns Single.error(exception)
        deleteTask.delete(task)
            .test()
            .assertComplete()
            .assertError(exception)
    }
}