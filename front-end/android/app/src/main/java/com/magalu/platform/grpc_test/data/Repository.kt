package com.magalu.platform.grpc_test.data

import com.magalu.platform.grpc_test.domain.model.Task
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getAllTasks(): Single<List<Task>>
    fun deleteTask(task: Task): Single<Task>
    fun saveTask(task: Task): Single<Task>
}