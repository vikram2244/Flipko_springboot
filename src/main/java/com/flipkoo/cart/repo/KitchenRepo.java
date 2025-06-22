package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.KitchenData;
@Repository
public interface KitchenRepo extends JpaRepository<KitchenData, Integer>{

}
