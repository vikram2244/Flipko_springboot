package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.ComputerEntity;
@Repository
public interface ComputerRepo extends JpaRepository<ComputerEntity, Integer>{

}
