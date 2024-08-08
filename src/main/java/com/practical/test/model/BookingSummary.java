package com.practical.test.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingSummary {
    private double totalConsumptionCost;
    private int totalParticipants;
    private List<Booking> bookings;

    public double getTotalConsumptionCost() {
        return totalConsumptionCost;
    }

    public void setTotalConsumptionCost(double totalConsumptionCost) {
        this.totalConsumptionCost = totalConsumptionCost;
    }

    public int getTotalParticipants() {
        return totalParticipants;
    }

    public void setTotalParticipants(int totalParticipants) {
        this.totalParticipants = totalParticipants;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
