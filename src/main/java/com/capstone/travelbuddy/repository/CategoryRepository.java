package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
