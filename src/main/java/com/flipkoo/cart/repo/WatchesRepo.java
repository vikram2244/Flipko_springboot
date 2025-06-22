package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.WatchesData;


@Repository
public interface WatchesRepo extends JpaRepository<WatchesData, Integer>{

}
