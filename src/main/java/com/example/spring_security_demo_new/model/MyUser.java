package com.example.spring_security_demo_new.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyUser {
    @Id
    private Integer id;
    private String username;
    private String password;
}
