package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.model.Task
import io.reactivex.Single

interface DeleteTask {
    fun delete(task: Task): Single<Task>
}

class DeleteTaskImpl(
    private val repository: Repository
): DeleteTask {
    override fun delete(task: Task): Single<Task> {
        return repository.deleteTask(task)
    }
}