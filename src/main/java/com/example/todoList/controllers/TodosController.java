package com.example.todoList.controllers;

import com.example.todoList.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.todoList.services.TodoService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/todos")
public class TodosController {

    @Autowired
    public TodoService todoService;
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getAllTodosService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Todo>> getTodoByIdService(@PathVariable long id){
        return new ResponseEntity<Optional<Todo>>(todoService.getTodoByIdService(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Todo> createTodoService(@RequestBody Todo todo){
        return new ResponseEntity<Todo>(todoService.createTodoService(todo),HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo){
        todo.setId(id);
        return new ResponseEntity<Todo>(todoService.updateTodoService(id,todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){
        return new ResponseEntity<Void>(todoService.deleteTodoService(id),HttpStatus.NO_CONTENT);
    }
}
