package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class OrderItem {
    private final UUID id;
    private final String customerName;
    private final String customerPhone;
    private final Date pickupTime;
    private final UUID menuItemID;
    private final String dishName;
    private final int amount;
    private final Date serveDate;

    public OrderItem(@JsonProperty("id") UUID id,
                     @JsonProperty("customerName") String customerName,
                     @JsonProperty("customerPhone") String customerPhone,
                     @JsonProperty("pickupTime") Date pickupTime,
                     @JsonProperty("menuItemID") UUID menuItemID,
                     @JsonProperty("dishName") String dishName,
                     @JsonProperty("amount") int amount,
                     @JsonProperty("serveDate") Date serveDate) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.pickupTime = pickupTime;
        this.menuItemID = menuItemID;
        this.dishName = dishName;
        this.amount = amount;
        this.serveDate = serveDate;
    }


    public UUID getId() {
        return id;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public Date getServeDate() {
        return serveDate;
    }

    public int getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getDishName() {
        return dishName;
    }

    public UUID getMenuItemID() {
        return menuItemID;
    }
}
