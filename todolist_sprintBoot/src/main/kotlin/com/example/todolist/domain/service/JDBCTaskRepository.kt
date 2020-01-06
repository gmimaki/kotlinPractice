package com.example.todolist.domain.service

import com.example.todolist.domain.repository.TaskRepository
import org.springframework.stereotype.Repository
import com.example.todolist.domain.entity.Task
import com.example.todolist.error.NotFoundException
import org.springframework.jdbc.core.RowMapper
import com.example.todolist.extensions.queryForObject
import org.springframework.jdbc.core.JdbcTemplate

@Repository
class JDBCTaskRepository(private val jdbcTemplate: JdbcTemplate) : TaskRepository {
    private val rowMapper = RowMapper<Task> { rs, _ ->
        Task(rs.getLong("id"), rs.getString("content"), rs.getBoolean("done"))
    }

    override fun create(content: String): Task {
        jdbcTemplate.update("INSERT INTO task(content) VALUES(?)", content)
        val id: Long = jdbcTemplate.queryForObject("SELECT last_insert_id()") ?: throw NotFoundException()
        return Task(id, content, false)
    }

    override fun update(task: Task) {
        jdbcTemplate.update("UPDATE task SET content = ?, done =? WHERE id = ?",
            task.content,
            task.done,
            task.id)
    }

    override fun findAll(): List<Task> = jdbcTemplate.query("SELECT id, content, done FROM task", rowMapper)

    override fun findById(id: Long): Task? = jdbcTemplate.query("SELECT id, content, done FROM task WHERE id = ?", rowMapper, id).firstOrNull()
}