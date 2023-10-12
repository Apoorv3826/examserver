package com.pariksha.repo;

import com.pariksha.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//        public Optional<User> findByUsername(String username);
       public User findByUsername(String username);
}
