package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.domain.model.Task
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SaveTask {

    fun saveTask(task: Task): Single<Task>

}