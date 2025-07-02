package com.example.examenparcial2.data

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
