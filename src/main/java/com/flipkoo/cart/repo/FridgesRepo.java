package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.FridgeEntity;


@Repository
public interface FridgesRepo extends JpaRepository<FridgeEntity, Integer>{

}
