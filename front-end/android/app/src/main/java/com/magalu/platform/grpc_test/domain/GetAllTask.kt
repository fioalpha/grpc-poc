package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.domain.model.Task
import io.reactivex.rxjava3.core.Single

interface GetAllTask {
    fun getAll(): Single<List<Task>>
}

class GetAllTaskImpl(
    private val repository: Repository
): GetAllTask {
    override fun getAll(): Single<List<Task>> {
        return repository.getAllTasks()
            .onErrorResumeNext {
                //TODO Add logs
                Single.just(emptyList())
            }
    }
}