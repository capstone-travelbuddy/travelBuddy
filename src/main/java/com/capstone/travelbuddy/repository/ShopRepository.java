package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
	List<Shop> getShopsByCityId(int id);
	List<Shop> getShopsByCityIdAndCategoryType(int cityId, String categoryType);
}
