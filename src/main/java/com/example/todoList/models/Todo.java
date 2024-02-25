package com.example.todoList.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "todo_name")
    @NotBlank(message = "Name is mandatory")
    private String todoName;


    @Column(name = "is_completed")
    @JsonProperty("isCompleted")
    @NotNull
    private boolean isCompleted;
}
