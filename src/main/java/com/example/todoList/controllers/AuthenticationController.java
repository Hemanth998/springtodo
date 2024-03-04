package com.example.todoList.controllers;



import com.example.todoList.models.ApplicationUser;
import com.example.todoList.models.RegistrationDTO;
import com.example.todoList.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

//    @PostMapping("/login")
//    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
//        return authenticationService.loginUser(body.getUsername(), body.getPassword());
//    }
}