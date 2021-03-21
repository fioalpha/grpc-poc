package com.magalu.platform.grpc_test.di

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.GetAllTask
import com.magalu.platform.grpc_test.domain.GetAllTaskImpl
import com.magalu.platform.grpc_test.domain.model.Task
import com.magalu.platform.grpc_test.view.list.presenter.TaskListViewModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit

object InjectGraphDependencies {

    fun viewModel(): TaskListViewModel {
        return TaskListViewModel(getTaskAllUseCase())
    }

    private fun getTaskAllUseCase(): GetAllTask {
        return GetAllTaskImpl(object : Repository {
            override fun getAllTasks(): Single<List<Task>> {
                return Single.just(
                    listOf(
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test"),
                        Task(1,  "Test", "Test", "test")
                    )
                ).delay(1, TimeUnit.SECONDS)
            }

            override fun deleteTask(task: Task): Single<Task> {
                TODO("Not yet implemented")
            }

            override fun saveTask(task: Task): Single<Task> {
                TODO("Not yet implemented")
            }
        })
    }


}