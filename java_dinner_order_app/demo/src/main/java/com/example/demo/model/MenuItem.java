package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class MenuItem {
    private final UUID id;
    private final String name;
    private final String message;
    private final String price;
    private final String servingDate;
    private final String amountAvailable;

    public MenuItem(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("message") String message,
                    @JsonProperty("price") String price,
                    @JsonProperty("servingDate") String servingDate,
                    @JsonProperty("amount") String amountAvailable) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.price = price;
        this.servingDate = servingDate;
        this.amountAvailable = amountAvailable;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public String getServingDate() {
        return servingDate;
    }

    public String getAmountAvailable() {
        return amountAvailable;
    }

    public String getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
