package com.magalu.platform.grpc_test.domain.model

data class Task (
    val id: Int,
    val title: String,
    val description: String,
    val date: String
)
