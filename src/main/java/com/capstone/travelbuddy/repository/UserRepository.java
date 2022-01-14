package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
