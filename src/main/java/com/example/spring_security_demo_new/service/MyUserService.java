package com.example.spring_security_demo_new.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_security_demo_new.model.MyUser;
import com.example.spring_security_demo_new.repository.MyUserRepo;

@Service
public class MyUserService {

    @Autowired
    private MyUserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<MyUser> getAllUsers() {
        return repo.findAll();
    }

    public MyUser findByUsername(String username) {
        return repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public String addUser(MyUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);

        return "Saved successfully";
    }
}
