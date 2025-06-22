package com.flipkoo.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkoo.cart.entity.BooksEntity;

@Repository
public interface BooksRepo extends JpaRepository<BooksEntity, Integer>{

}
