package com.flipkoo.cart.repo;

import com.flipkoo.cart.entity.LoginEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<LoginEntity, Long> {
    Optional<LoginEntity> findById(Long id);
}