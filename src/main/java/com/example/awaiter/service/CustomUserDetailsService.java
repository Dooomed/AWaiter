package com.example.awaiter.service;
/*
import com.example.awaiter.model.User;
import com.example.awaiter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(userName);

        if(user == null) throw new UsernameNotFoundException("Unknown user: " + userName);

        return user;
    }

    public UserDetails saveUser(User user) throws Exception {
        if(loadUserByUsername(user.getUsername()) != null) throw new Exception("User exists!!!");

        return userRepository.save(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String role)  {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
*/