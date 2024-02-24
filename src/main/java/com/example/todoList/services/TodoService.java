package com.example.todoList.services;

import com.example.todoList.models.Todo;
import com.example.todoList.repositories.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    public TodosRepository todosRepository;
    public List<Todo> getAllTodosService(){
        return todosRepository.findAll();
    }

    public Todo createTodoService(Todo todo){
        return todosRepository.save(todo);
    }

    public Optional<Todo> getTodoByIdService(long id) {
        return todosRepository.findById(id);
    }

    public Todo updateTodoService(long id, Todo todo) {
        return todosRepository.save(todo);
    }

    public Void deleteTodoService(long id){
        todosRepository.deleteById(id);
        return null;
    }
}
