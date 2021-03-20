package com.magalu.platform.grpc_test.view.list.presenter

import androidx.annotation.VisibleForTesting
import com.magalu.platform.grpc_test.domain.DeleteTask
import com.magalu.platform.grpc_test.domain.GetAllTask
import com.magalu.platform.grpc_test.domain.model.Task
import com.magalu.platform.grpc_test.view.list.view.TaskListState
import com.magalu.platform.grpc_test.view.list.view.TaskView
import io.reactivex.Observable

class TaskListViewModel (
    private val getAllTask: GetAllTask
){

    private val tasks = mutableListOf<Task>()

    fun loadTask(): Observable<TaskListState> {
        return getAllTask.getAll().toObservable()
            .doOnNext {
                tasks.clear()
                tasks.addAll(tasks)
            }
            .map (::transform)
            .onErrorReturn (::handlerError)
            .cast(TaskListState::class.java)
            .startWith(Observable.just(TaskListState.LOADING))
    }

    private fun transform(data: List<Task>): TaskListState {
         val map = data.map {
            TaskView(it.title, it.description, it.date)
        }
        return TaskListState.Data(map)
    }

    private fun handlerError(error: Throwable): TaskListState {
        return TaskListState.Error(error.localizedMessage?: "Error")
    }

}