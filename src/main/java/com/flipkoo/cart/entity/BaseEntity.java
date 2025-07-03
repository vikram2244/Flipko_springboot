package com.flipkoo.cart.entity;

public abstract class BaseEntity {
    private Integer id;
    
    // getter and setter
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
}