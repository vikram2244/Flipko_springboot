package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.WomenData;

@Repository
public interface WomenRepo extends JpaRepository<WomenData, Integer>{

}
