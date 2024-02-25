package com.example.todoList.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "user name should not be blank")
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "email should not be blank")
    @Email(message = "email address should be valid")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "password should not be blank")
    @Column(name = "password")
    private String password;

}
