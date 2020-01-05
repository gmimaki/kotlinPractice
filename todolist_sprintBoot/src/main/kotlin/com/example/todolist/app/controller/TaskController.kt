package com.example.todolist.app.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.example.todolist.domain.entity.Task

@Controller
@RequestMapping("tasks")
class TaskController {
    @GetMapping("")
    fun index(model: Model): String {
        val tasks = listOf(
                Task(1, "障子を張り替える", false),
                Task(2, "定期検診にいく", true)
        )
        model.addAttribute("tasks", tasks)
        return "tasks/index"
    }
}