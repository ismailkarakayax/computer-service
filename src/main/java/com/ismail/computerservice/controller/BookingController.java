package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateBookingDto;
import com.ismail.computerservice.model.Booking;
import com.ismail.computerservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingDto createBookingDto) {
        Booking booking = bookingService.createBooking(createBookingDto);
        return ResponseEntity.ok(booking);

    }
}
