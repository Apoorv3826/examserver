package com.pariksha.services.impl;

import com.pariksha.models.User;
import com.pariksha.models.UserRole;
import com.pariksha.repo.RoleRepository;
import com.pariksha.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService implements com.pariksha.services.UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("User is already there");
        }else{
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }
}
