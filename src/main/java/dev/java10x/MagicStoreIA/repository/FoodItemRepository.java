package dev.java10x.MagicStoreIA.repository;

import dev.java10x.MagicStoreIA.model.FoodItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}
