package com.practical.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumptionType {
    private String id;
    private String name;
    private double maxPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
