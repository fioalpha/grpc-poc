package com.magalu.platform.grpc_test.view.list.view

sealed class TaskListState {
    object LOADING: TaskListState()
    data class Data(val data: List<TaskView>): TaskListState()
    data class Error(val message: String): TaskListState()
}

data class TaskView(
    val title: String,
    val description: String,
    val data: String
)