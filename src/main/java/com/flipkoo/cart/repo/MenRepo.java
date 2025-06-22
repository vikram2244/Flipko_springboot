package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.MenData;

@Repository
public interface MenRepo extends JpaRepository<MenData, Integer>{

}
