package com.pariksha.controller;

import com.pariksha.models.Roles;
import com.pariksha.models.User;
import com.pariksha.models.UserRole;
import com.pariksha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User createUser(@RequestBody User user){

        user.setProfile("default.png");

        Set<UserRole> roles = new HashSet<>();
        Roles roles1 = new Roles();
        roles1.setRoleId(46L);
        roles1.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(roles1);

        roles.add(userRole);

        return this.userService.createUser(user,roles);
    }

    @GetMapping("/{username}")
    public User getUser (@PathVariable("username") String username){
        return this.userService.getUser(username);
    }


}
