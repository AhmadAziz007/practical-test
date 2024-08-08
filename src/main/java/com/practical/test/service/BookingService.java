package com.practical.test.service;

import com.practical.test.model.Booking;
import com.practical.test.model.BookingSummary;
import com.practical.test.model.Consumption;
import com.practical.test.model.ConsumptionType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingService {

    private static final String BOOKING_API_URL = "https://66876cc30bc7155dc017a662.mockapi.io/api/dummy-data/bookingList";
    private static final String CONSUMPTION_API_URL = "https://6686cb5583c983911b03a7f3.mockapi.io/api/dummy-data/masterJenisKonsumsi";

    private final RestTemplate restTemplate;

    public BookingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Booking> getBookingList() {
        Booking[] bookings = restTemplate.getForObject(BOOKING_API_URL, Booking[].class);
        return Arrays.asList(bookings);
    }

    public List<ConsumptionType> getConsumptionTypes() {
        ConsumptionType[] consumptionTypes = restTemplate.getForObject(CONSUMPTION_API_URL, ConsumptionType[].class);
        return Arrays.asList(consumptionTypes);
    }

    public BookingSummary getBookingSummary() {
        List<Booking> bookings = getBookingList();
        List<ConsumptionType> consumptionTypes = getConsumptionTypes();

        // Calculate summary data
        double totalConsumptionCost = 0;
        int totalParticipants = 0;

        for (Booking booking : bookings) {
            totalParticipants += booking.getParticipants();
            for (Consumption consumption : booking.getListConsumption()) {
                for (ConsumptionType consumptionType : consumptionTypes) {
                    if (consumption.getName().equals(consumptionType.getName())) {
                        totalConsumptionCost += consumptionType.getMaxPrice() * booking.getParticipants();
                    }
                }
            }
        }

        BookingSummary summary = new BookingSummary();
        summary.setTotalConsumptionCost(totalConsumptionCost);
        summary.setTotalParticipants(totalParticipants);
        summary.setBookings(bookings);

        return summary;
    }
}