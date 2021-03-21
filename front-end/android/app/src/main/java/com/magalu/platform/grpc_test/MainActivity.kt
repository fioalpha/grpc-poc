package com.magalu.platform.grpc_test

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import com.magalu.platform.grpc_test.di.InjectGraphDependencies
import com.magalu.platform.grpc_test.view.list.components.MainContainer
import com.magalu.platform.grpc_test.view.list.components.TaskViewContainer
import com.magalu.platform.grpc_test.view.list.presenter.TaskListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TaskListViewModel by lazy { InjectGraphDependencies.viewModel() }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContainer { TaskViewContainer(viewModel = viewModel) }
        }
    }

}