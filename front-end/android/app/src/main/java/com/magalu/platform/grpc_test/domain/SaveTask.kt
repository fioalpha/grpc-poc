package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.model.Task
import io.reactivex.Single

interface SaveTask {
    fun saveTask(task: Task): Single<Task>
}

class SaveTaskImpl(
    private val repository: Repository
): SaveTask {
    override fun saveTask(task: Task): Single<Task> {
        return repository.saveTask(task)
    }
}