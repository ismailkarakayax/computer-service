package com.ismail.computerservice.repository;

import com.ismail.computerservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByBookingDate(Date date);


    @Query(value = "SELECT MAX(booking_date) FROM \"BOOKING\"", nativeQuery = true)
    Date findMaxBookingDate();

    @Query(value = "SELECT * FROM \"BOOKING\" WHERE booking_date = (SELECT MAX(booking_date) FROM \"BOOKING\")", nativeQuery = true)
    List<Booking> findBookingsOnLastDay();
}
