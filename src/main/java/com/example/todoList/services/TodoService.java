package com.example.todoList.services;

import com.example.todoList.exceptions.ResourceNotFoundException;
import com.example.todoList.models.Todo;
import com.example.todoList.repositories.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Todo getTodoByIdService(long id) {
        return todosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Todo found with this id : "+id));
    }

    public Todo updateTodoService(long id, Todo todo) {
        if(todosRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No Todo found with this id : "+id);
        }
        return todosRepository.save(todo);
    }

    public Void deleteTodoService(long id){
        if(todosRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No Todo found with this id : "+id);
        }
        todosRepository.deleteById(id);
        return null;
    }
}
