package com.magalu.platform.grpc_test.data

import android.util.Log
import com.magalu.platform.grpc_test.TaskProto
import com.magalu.platform.grpc_test.TaskServiceGrpc
import com.magalu.platform.grpc_test.data.datasource.protopof.ProtoDataSource
import com.magalu.platform.grpc_test.domain.model.Task
import io.grpc.ManagedChannelBuilder
import io.reactivex.Single
import java.util.concurrent.TimeUnit

interface Repository {
    fun getAllTasks(): Single<List<Task>>
    fun deleteTask(task: Task): Single<Task>
    fun saveTask(task: Task): Single<Task>
}

class RepositoryImpl(
    private val protoDataSource: ProtoDataSource
): Repository {

    override fun getAllTasks(): Single<List<Task>> {
        return protoDataSource.getAll()
            .map { it.map { task -> task.transformTo() } }.delay(2, TimeUnit.SECONDS)
    }

    override fun deleteTask(task: Task): Single<Task> {
        TODO("Not yet implemented")
    }

    override fun saveTask(task: Task): Single<Task> {
        TODO("Not yet implemented")
    }

    private fun TaskProto.TaskT.transformTo (): Task {
        return Task(id, title, description, date)
    }
}