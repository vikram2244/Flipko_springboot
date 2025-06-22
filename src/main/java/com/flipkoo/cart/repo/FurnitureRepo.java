package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.FurnitureEntity;

@Repository
public interface FurnitureRepo extends JpaRepository<FurnitureEntity, Integer>{

}
