package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
