package com.magalu.platform.grpc_test.view.list.components

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.nio.channels.FileLockInterruptionException

@Composable
fun MainContainer (
    content: @Composable () -> Unit,
    floatButtonAction: () -> Unit,
    isFloatButtonShow: Boolean = true
) {
    Scaffold(
        floatingActionButton = {
            if(isFloatButtonShow) floatingActionButtonExtension(floatButtonAction)
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
         MaterialTheme {
            content.invoke()
        }
    }
}

@Composable
fun floatingActionButtonExtension(action: () -> Unit) {
    FloatingActionButton(
        onClick = action,
        backgroundColor = Color.Blue,
        contentColor = Color.White,
    ) {
        Icon(Icons.Filled.Add, "")
    }
}