package com.magalu.platform.grpc_test.di

import com.magalu.platform.grpc_test.data.Repository
import com.magalu.platform.grpc_test.data.RepositoryImpl
import com.magalu.platform.grpc_test.data.datasource.protopof.ProtoDataSource
import com.magalu.platform.grpc_test.data.datasource.protopof.ProtoDataSourceImpl
import com.magalu.platform.grpc_test.data.datasource.protopof.ProtoServices
import com.magalu.platform.grpc_test.data.datasource.protopof.ProtoServicesImpl
import com.magalu.platform.grpc_test.domain.GetAllTask
import com.magalu.platform.grpc_test.domain.GetAllTaskImpl
import com.magalu.platform.grpc_test.navigation.Navigator
import com.magalu.platform.grpc_test.navigation.NavigatorImpl
import com.magalu.platform.grpc_test.view.list.presenter.TaskListViewModel

private const val HOST = "165.232.147.56"
private const val PORT = 50051

object InjectGraphDependencies {

    fun viewModelProvider(): TaskListViewModel {
        return TaskListViewModel(getTaskAllUseCaseProvider())
    }

    fun navigationProvider(): Navigator {
        return NavigatorImpl
    }

    private fun getTaskAllUseCaseProvider(): GetAllTask {
        return GetAllTaskImpl(repositoryProvider())
    }

    private fun protoServiceProvider(): ProtoServices {
        return ProtoServicesImpl(HOST, PORT)
    }

    private fun protoDataSourceProvider(): ProtoDataSource {
        return ProtoDataSourceImpl(protoServiceProvider())
    }

    private fun repositoryProvider(): Repository {
        return RepositoryImpl(protoDataSourceProvider())
    }

}