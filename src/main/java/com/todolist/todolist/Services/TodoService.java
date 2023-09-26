package com.todolist.todolist.Services;

import com.todolist.todolist.Entities.Todo;
import com.todolist.todolist.Repositories.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
    public Optional<Todo> show(Long id) {
        return todoRepository.findById(id);
    }
}
