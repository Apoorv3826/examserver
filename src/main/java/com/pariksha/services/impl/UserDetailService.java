package com.pariksha.services.impl;

import com.pariksha.models.User;
import com.pariksha.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User user = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not found"));
        User user = userRepository.findByUsername(username);
        if (user == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("No user found");
        }
        return user;
    }
}
