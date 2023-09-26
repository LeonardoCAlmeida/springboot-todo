package com.todolist.todolist.Repositories;

import com.todolist.todolist.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
