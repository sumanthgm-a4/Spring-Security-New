package com.example.spring_security_demo_new.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_security_demo_new.model.MyUser;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
    Optional<MyUser> findByUsername(String username);
}
