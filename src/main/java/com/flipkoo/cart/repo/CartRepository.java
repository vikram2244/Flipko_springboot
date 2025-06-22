package com.flipkoo.cart.repo;

import com.flipkoo.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findByUserId(String userId);
    CartEntity findByUserIdAndProductIdAndProductType(String userId, Integer productId, String productType);
}