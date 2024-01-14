package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateBookingDto;
import com.ismail.computerservice.model.Booking;
import com.ismail.computerservice.model.Repair;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.BookingRepository;
import com.ismail.computerservice.repository.RepairRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RepairRepository repairRepository;

    public BookingService(BookingRepository bookingRepository, RepairRepository repairRepository) {
        this.bookingRepository = bookingRepository;
        this.repairRepository = repairRepository;
    }

    public Booking createBooking(CreateBookingDto createBookingDto) {

        Repair repair= repairRepository.findById(createBookingDto.getRepairId())
                .orElseThrow(() -> new RuntimeException("Repair not found"));

        List<Booking> userBookings= bookingRepository.findByUserId(createBookingDto.getUserId());

        LocalDateTime bookingDateTime = createBookingDto.getBookingDate().atStartOfDay();

        if(!canBookAppintment(userBookings, createBookingDto.getBookingDate(), repair.getDuration())){
            throw new RuntimeException("Can't book appointment");
        }

        Booking booking = new Booking();
        booking.setNote(createBookingDto.getNote());
        booking.setBookingDate(bookingDateTime);
        booking.setStatus(false);
        booking.setRepair(repair);

        User user = new User();
        user.setId(createBookingDto.getUserId());
        booking.setUser(user);

        return bookingRepository.save(booking);
    }

    public boolean canBookAppintment(List<Booking> userBookings, LocalDate bookingDate, Integer repairDuration){
        int totalDurationForDay=repairDuration;

        for(Booking booking: userBookings){
            LocalDate bookingDay = booking.getBookingDate().toLocalDate();

            if(bookingDay.equals(bookingDate)){
                totalDurationForDay+=booking.getRepair().getDuration();
            }
        }

        return totalDurationForDay <= 10;
    }

}
