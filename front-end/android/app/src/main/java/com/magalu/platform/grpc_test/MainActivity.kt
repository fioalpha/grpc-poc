package com.magalu.platform.grpc_test

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import com.magalu.platform.grpc_test.domain.GetAllTask
import com.magalu.platform.grpc_test.domain.model.Task
import com.magalu.platform.grpc_test.view.list.components.MainContainer
import com.magalu.platform.grpc_test.view.list.components.TaskViewContainer
import com.magalu.platform.grpc_test.view.list.presenter.TaskListViewModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val getAllTaskMock = object : GetAllTask {
        override fun getAll(): Single<List<Task>> {
            return Single.just(
                listOf(
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test"),
                    Task(1,  "Test", "Test", "test")
                )
            ).delay(1, TimeUnit.SECONDS)
        }
    }

    private val viewModel: TaskListViewModel by lazy { TaskListViewModel(getAllTaskMock) }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContainer { TaskViewContainer(viewModel = viewModel) }
        }
    }

}