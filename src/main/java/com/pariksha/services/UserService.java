package com.pariksha.services;

import com.pariksha.models.User;
import com.pariksha.models.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser (User user, Set<UserRole> userRoles);

    public User getUser(String username);
}
