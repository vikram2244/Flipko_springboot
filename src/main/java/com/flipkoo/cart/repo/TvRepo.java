package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.TvsData;


@Repository
public interface TvRepo extends JpaRepository<TvsData, Integer>{

}
