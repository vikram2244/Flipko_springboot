package com.flipkoo.cart.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.MobileEntity;

@Repository
public interface MobileRepo extends JpaRepository<MobileEntity, Integer>{
    Optional<MobileEntity> findTopByProductOrderByIdDesc(String product);

}
