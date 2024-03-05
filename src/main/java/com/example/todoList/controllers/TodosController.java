package com.example.todoList.controllers;

import com.example.todoList.models.Todo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.todoList.services.TodoService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/api/v1/todos")
@Validated
public class TodosController {

    @Autowired
    public TodoService todoService;
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(Principal principal){
        System.out.println("User : " + principal.getName());
        System.out.println("Postman");
        return new ResponseEntity<List<Todo>>(todoService.getAllTodosService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoByIdService(@PathVariable Long id){
            return new ResponseEntity<Todo>(todoService.getTodoByIdService(id),HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Todo> createTodoService(@Valid @RequestBody Todo todo){
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
