package com.example.spring_security_demo_new.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security_demo_new.model.MyUser;
import com.example.spring_security_demo_new.service.MyUserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @Autowired
    private MyUserService service;

    @GetMapping(value="/hello")
    public String greet(HttpServletRequest request) {
        return "Hello " + request.getSession().getId();
    }

    @GetMapping("/users")
    public List<MyUser> getAll() {
        return service.getAllUsers();
    } 

    @PostMapping("/users")
    public String addUser(@RequestBody MyUser user) {
        return service.addUser(user);
    }
}
