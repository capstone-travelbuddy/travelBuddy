package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query(value = "SELECT avg(rating) FROM Review WHERE shop.id = ?1")
	Double avg(int id);
}
