package com.magalu.platform.grpc_test.data.datasource.protopof

import com.magalu.platform.grpc_test.TaskServiceGrpc
import io.grpc.ManagedChannelBuilder

interface ProtoServices {
    fun getTaskService(): TaskServiceGrpc.TaskServiceBlockingStub
}

internal class ProtoServicesImpl (
    private val host: String,
    private val port: Int
): ProtoServices {
    private val channel by lazy {
        ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build()
    }

    private val taskServiceGrpc by lazy {
        TaskServiceGrpc.newBlockingStub(channel)
    }

    override fun getTaskService(): TaskServiceGrpc.TaskServiceBlockingStub {
        return taskServiceGrpc
    }

}