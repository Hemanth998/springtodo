package com.example.todoList.repositories;

import com.example.todoList.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todo,Long> {
}
