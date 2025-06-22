package com.flipkoo.cart.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "acdata")
public class AcEntity {

    @Id
    private Integer id;
    private String product;
    private String image;
    private String brand;
    private String model;
    private double price;
    private String category;
    private String description;

    public AcEntity() {}

    @JsonSetter("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @JsonSetter("price")
    public void setPrice(String price) {
        try {
            this.price = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format: " + price, e);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}