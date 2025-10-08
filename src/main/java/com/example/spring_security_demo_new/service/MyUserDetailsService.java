package com.example.spring_security_demo_new.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_security_demo_new.model.MyUser;
import com.example.spring_security_demo_new.model.MyUserDetails;
import com.example.spring_security_demo_new.repository.MyUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new MyUserDetails(user);
    }

    

}
