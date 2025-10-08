package com.example.spring_security_demo_new.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

    private final MyUser myUser;

    public MyUserDetails(MyUser user) {
        this.myUser = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER")); 
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return myUser.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return myUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return UserDetails.super.isEnabled();
    }
    
}
