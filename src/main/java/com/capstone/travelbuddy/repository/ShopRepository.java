package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
	List<Shop> getShopsByCityIdAndCategoryType(int cityId, String categoryType);
	List<Shop> findByNameIgnoreCaseContaining(String name);

}
