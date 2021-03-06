package com.magalu.platform.grpc_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import com.magalu.platform.grpc_test.di.InjectGraphDependencies
import com.magalu.platform.grpc_test.view.list.components.MainContainer
import com.magalu.platform.grpc_test.view.list.components.TaskViewContainer
import com.magalu.platform.grpc_test.view.list.presenter.TaskListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TaskListViewModel by lazy { InjectGraphDependencies.viewModelProvider() }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContainer(
                content = { TaskViewContainer(viewModel = viewModel) },
                floatButtonAction = {
                    InjectGraphDependencies.navigationProvider()
                        .goNewTask(this)
                },
            )
        }
    }

}