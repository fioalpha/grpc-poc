package com.magalu.platform.grpc_test.domain

import com.magalu.platform.grpc_test.domain.model.Task
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GetAllTask {
    fun getAll(): Single<List<Task>>
}