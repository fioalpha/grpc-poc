package com.magalu.platform.grpc_test.view.list.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MainContainer (content: @Composable () -> Unit) {
    Scaffold {
        MaterialTheme {
            content.invoke()
        }
    }
}