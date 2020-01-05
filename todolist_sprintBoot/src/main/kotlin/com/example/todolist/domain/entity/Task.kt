package com.example.todolist.domain.entity

data class Task(val id: Long,
                val content: String,
                val done: Boolean)