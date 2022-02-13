package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

public class CheckoutDTO {
    private int costPerHour;
    private int totalCost;

    public CheckoutDTO() {

    }

    public CheckoutDTO(int costPerHour, int totalCost) {
        this.costPerHour = costPerHour;
        this.totalCost = totalCost;
    }


    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
