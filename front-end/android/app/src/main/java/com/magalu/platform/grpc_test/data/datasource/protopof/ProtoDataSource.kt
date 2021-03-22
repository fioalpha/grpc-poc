package com.magalu.platform.grpc_test.data.datasource.protopof

import android.util.Log
import com.magalu.platform.grpc_test.TaskProto
import io.reactivex.Single

interface ProtoDataSource {
    fun getAll(): Single<List<TaskProto.TaskT>>
}

class ProtoDataSourceImpl(
    private val protoService: ProtoServices
): ProtoDataSource {

    override fun getAll(): Single<List<TaskProto.TaskT>> {
        return Single.defer {
            val taskProtoRequest = TaskProto.Empty.newBuilder().build()
            try {
                Single.just(protoService.getTaskService().list(taskProtoRequest).tasksList)
            } catch (e: Exception) {
                Log.e("ERROR", "PROTO", e)
                Single.error(Exception())
            }
        }
    }

}