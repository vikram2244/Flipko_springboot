package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.SpeakersData;

@Repository
public interface SpeakersRepo extends JpaRepository<SpeakersData, Integer>{

}
