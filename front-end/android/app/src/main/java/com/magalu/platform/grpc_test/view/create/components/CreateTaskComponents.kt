package com.magalu.platform.grpc_test.view.create.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants


@Composable
fun FormCreateTask() {
    val titleInput = remember { mutableStateOf(TextFieldValue("")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }

    Column() {
        InputText(text = titleInput, "Título da tarefa",  "Titulo")
        InputText(text = description, "Descricao da terafa", "Descrição")
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.fillMaxWidth().
                    padding(8.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Criar Tarefa")
            }
        }

    }
}

@Composable
fun InputText(
    text: MutableState<TextFieldValue>,
    placeHolder: String,
    label: String
) {
    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        placeholder = { Text(text = placeHolder) },
        label = { Text(text = label) }
    )
}

@Preview
@Composable
fun FormPreviewer () {
    FormCreateTask()
}