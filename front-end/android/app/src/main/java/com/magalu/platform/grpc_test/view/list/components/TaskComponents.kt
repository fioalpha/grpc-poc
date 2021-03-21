package com.magalu.platform.grpc_test.view.list.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.magalu.platform.grpc_test.view.list.presenter.TaskListViewModel
import com.magalu.platform.grpc_test.view.list.view.TaskListState
import com.magalu.platform.grpc_test.view.list.view.TaskView

@Composable
fun TaskItemComponent (
    taskView: TaskView,
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        Column(
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = taskView.title
            )
            Text(text = taskView.description)
            Text(text = taskView.data)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun LoadingViewComponent(
     visibility: Boolean
) {
    AnimatedVisibility(visible = visibility) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Composable
fun TaskListComponent (taskListState: TaskListState.Data) {
    LazyColumn {
        items(taskListState.data) { taskViewItem ->
            TaskItemComponent(taskView = taskViewItem)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun TaskViewContainer (
    viewModel: TaskListViewModel
) {
    val items = viewModel.loadTask()
        .subscribeAsState(initial = TaskListState.LOADING).value
    when (items) {
        is TaskListState.LOADING -> LoadingViewComponent(visibility = true)
        is TaskListState.Data -> TaskListComponent(taskListState = items)
        is TaskListState.Error -> ErrorContainer(message = items.message)
    }
}

@Composable
fun ErrorContainer (message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = message)
    }
}















