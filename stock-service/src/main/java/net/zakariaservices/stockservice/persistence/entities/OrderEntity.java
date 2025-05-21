package net.zakariaservices.stockservice.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderEntity {
    @Id
    private String orderId;
    private String name;
    private int qty;
    private double price;
    private String userEmail;

    public String getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
