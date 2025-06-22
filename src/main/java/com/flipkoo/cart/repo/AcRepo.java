package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.AcEntity;
@Repository
public interface AcRepo extends JpaRepository<AcEntity, Integer>{

}
