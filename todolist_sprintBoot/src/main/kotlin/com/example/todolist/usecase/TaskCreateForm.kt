package com.example.todolist.usecase

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class TaskCreateForm {
    @NotBlank
    @Size(max = 20)
    val content: String? = null
}