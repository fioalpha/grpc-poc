package com.magalu.platform.grpc_test.view.list.presenter

import android.util.Log
import com.magalu.platform.grpc_test.domain.DeleteTask
import com.magalu.platform.grpc_test.domain.GetAllTask
import com.magalu.platform.grpc_test.domain.model.Task
import com.magalu.platform.grpc_test.view.list.view.TaskListState
import com.magalu.platform.grpc_test.view.list.view.TaskView
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test

class TaskListViewModelTest {

    private val allTaskMock = mockk<GetAllTask>()
    private val deleteTask = mockk<DeleteTask>()
    private val taskListViewModel = TaskListViewModel(
        allTaskMock
    )

    @Test
    fun `load data With success` () {
        val tasksMock = listOf(Task(1, "TITLE", "DESCRIPTION", "2020-01-01"))
        every { allTaskMock.getAll()} returns Single.just(tasksMock)

        val values = taskListViewModel.loadTask()
            .test()
            .assertComplete()
            .values()

        Assert.assertEquals(
            listOf(
                TaskListState.LOADING,
                TaskListState.Data(
                    listOf(TaskView("TITLE", "DESCRIPTION", "2020-01-01"))
                )
            ),
           values
        )
    }

    @Test
    fun `load data With error` () {
        val error = Throwable()
        every { allTaskMock.getAll()} returns Single.error(error)

        val values = taskListViewModel.loadTask()
            .test()
            .assertComplete()
            .values()

        Assert.assertEquals(
            listOf(
                TaskListState.LOADING,
                TaskListState.Error("Error")
            ),
            values
        )
    }
}