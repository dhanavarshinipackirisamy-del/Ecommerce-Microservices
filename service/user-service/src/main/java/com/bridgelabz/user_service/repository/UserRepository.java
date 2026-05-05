package com.bridgelabz.user_service.repository;



import com.bridgelabz.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;   // 🔥 ADD THIS

public interface UserRepository extends JpaRepository<User, Long> {

    // 🔥 ADD THIS METHOD
    Optional<User> findByEmail(String email);
}