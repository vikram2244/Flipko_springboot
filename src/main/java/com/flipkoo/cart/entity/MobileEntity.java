package com.flipkoo.cart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mobilefetch")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileEntity extends BaseEntity{

    @Id
    private Integer id; // Must be Integer to match parsedId
    private String product;
    private String image;
    private String brand;
    private String model;
    private Double price;
    private String category;
    private String description;

    public MobileEntity() {}

    public void setId(Integer id) {
        this.id = id;
    }

    // Custom JSON setter for string-to-integer conversion
    @JsonSetter("id")
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            this.id = null;
        } else {
            try {
                this.id = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid ID format: " + id, e);
            }
        }
    }

    public Integer getId() {
        return id;
    }

    // Other getters and setters remain unchanged
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

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonSetter("price")
    public void setPrice(String price) {
        if (price == null || price.trim().isEmpty()) {
            this.price = null;
        } else {
            try {
                this.price = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid price format: " + price, e);
            }
        }
    }

    public Double getPrice() {
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