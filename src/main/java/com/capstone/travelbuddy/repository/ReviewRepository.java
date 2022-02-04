package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query(value = "SELECT avg(rating) FROM Review WHERE shop.id = ?1")
	Double avg(int id);

	default double avgRound(int precision, int id) {
		Double value = avg(id);
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}

	@Query(value = "SELECT avg(rating) FROM Review WHERE shop.id = ?1 AND userType = 1")
	Double localAvg(int id);

	default double localAvgRound(int precision, int id) {
		Double value = localAvg(id);
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}

	@Query(value = "SELECT avg(rating) FROM Review WHERE shop.id = ?1 AND userType = 2")
	Double travelerAvg(int id);

	default double travelerAvgRound(int precision, int id) {
		Double value = travelerAvg(id);
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}

}
