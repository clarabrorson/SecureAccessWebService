package com.clara.SecureAccessWebService.Entity;

import jakarta.persistence.*;

/**
 * This class is an entity class that represents the order table in the database
 * @JoinColumn(name = "user_id") is used to map the user_id column in the order table to the user table
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String quantity;

    @JoinColumn(name = "user_id") // Detta måste matcha namnet på kolumnen i databasen
    private ApplicationUser user;
    public Order() {
    }

    public Order(Long id, String productName, String quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
