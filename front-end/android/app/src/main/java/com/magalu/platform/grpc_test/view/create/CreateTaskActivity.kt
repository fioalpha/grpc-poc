package com.magalu.platform.grpc_test.view.create

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.magalu.platform.grpc_test.di.InjectGraphDependencies
import com.magalu.platform.grpc_test.view.create.components.FormCreateTask
import com.magalu.platform.grpc_test.view.list.components.MainContainer

class CreateTaskActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainContainer(
                content = { FormCreateTask() },
                floatButtonAction = {
                    InjectGraphDependencies.navigationProvider()
                        .goNewTask(this)
                },
                isFloatButtonShow = false
            )
        }

    }
}