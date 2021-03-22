package com.magalu.platform.grpc_test.navigation

import android.content.Context
import android.content.Intent
import com.magalu.platform.grpc_test.view.create.CreateTaskActivity

interface Navigator {
    fun goNewTask(context: Context)
}

object NavigatorImpl: Navigator {
    override fun goNewTask(context: Context) {
        Intent(context, CreateTaskActivity::class.java).apply {
            context.startActivity(this)
        }
    }

}