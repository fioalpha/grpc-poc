package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.model.Task
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import junit.framework.TestCase

import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

class GetAllTaskTest {

    private val repositoryMock = mockk<Repository>()

    private val getAllTask = GetAllTaskImpl(repositoryMock)

    @Test
    fun `get all task Return list tasks`() {
        val mockExpectedValue = listOf(Task(1, "TEST", "This is test", "2021-04-01"))
        every { repositoryMock.getAllTasks() } returns  Single.just(mockExpectedValue)
        getAllTask.getAll().test()
            .assertComplete()
            .assertNoErrors()
    }

    @Test
    fun `get all task With Exception Return Empty List`() {
        every { repositoryMock.getAllTasks() }  returns Single.error(Throwable("Error"))
        getAllTask.getAll()
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue{
                it.isEmpty()
            }
    }

}