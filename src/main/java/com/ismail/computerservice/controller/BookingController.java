package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateBookingDto;
import com.ismail.computerservice.model.Booking;
import com.ismail.computerservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingDto createBookingDto) {
        try{
            Booking booking = bookingService.createBooking(createBookingDto);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/getall")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/user/getbyid")
    public ResponseEntity<Booking> getBookingById(@RequestParam Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteBookingById(@RequestParam Long id) {
        try{
            bookingService.deleteBookingById(id);
            return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Failed to delete booking", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/updatestatus")
    public ResponseEntity<Booking> updateBookingStatus(@RequestBody Long id) {
        try{
            Booking booking = bookingService.updateBookingStatus(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
