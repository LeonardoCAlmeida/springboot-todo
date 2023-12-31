package com.todolist.todolist.Controllers;

import com.todolist.todolist.Entities.Todo;
import com.todolist.todolist.Services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }
    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

    @GetMapping("{id}")
    public Optional<Todo> show(@PathVariable("id") Long id) {
        return todoService.show(id);
    }
}
