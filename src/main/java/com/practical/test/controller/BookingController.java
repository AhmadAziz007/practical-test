package com.practical.test.controller;

import com.practical.test.model.BookingSummary;
import com.practical.test.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summary")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public BookingSummary getBookingSummary() {
        return bookingService.getBookingSummary();
    }
}
