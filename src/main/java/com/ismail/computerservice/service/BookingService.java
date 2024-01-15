package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateBookingDto;
import com.ismail.computerservice.model.Booking;
import com.ismail.computerservice.model.Repair;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.BookingRepository;
import com.ismail.computerservice.repository.RepairRepository;
import com.ismail.computerservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RepairRepository repairRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, RepairRepository repairRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.repairRepository = repairRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(CreateBookingDto createBookingDto) {

        //Randevu alınan Repairi getir
        Repair repair= repairRepository.findById(createBookingDto.getRepairId())
                .orElseThrow(() -> new RuntimeException("Repair not found"));

        //Randevu alan User getir
        User user = userRepository.findById(createBookingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        //Randevu alınan tarihdeki tüm bookingdateleri getir
        List<Booking> bookingsToday= bookingRepository.findByBookingDate(createBookingDto.getBookingDate());

        //Dtoları gir
        Booking booking = new Booking();

        booking.setNote(createBookingDto.getNote());
        booking.setBookingDate(createBookingDto.getBookingDate());
        booking.setStatus(false);
        booking.setRepair(repair);
        booking.setUser(user);

        //O gün alınan toplam randevu süresi 10 saati geçiyor mu
        int dailyLimit = 10;

        if(!isTotalDurationWithinLimit(bookingsToday,repair.getDuration(), dailyLimit)) {
            // Try to book for the next day
            Date nextDay = getNextDay(createBookingDto.getBookingDate());
            List<Booking> bookingsNextDay = bookingRepository.findByBookingDate(nextDay);

            // Bir sonraki güne de randevu alabiliyorsa, tarihi güncelle
            if (isTotalDurationWithinLimit(bookingsNextDay, repair.getDuration(), dailyLimit)) {
                booking.setBookingDate(nextDay);
            } else {
                throw new IllegalArgumentException("Cannot book appointment due to exceeding the daily limit");
            }
        }
        return bookingRepository.save(booking);
    }
    //O gün alınan toplam randevu şüresi 10 saati geçiyor mu metodu
    public boolean isTotalDurationWithinLimit(List<Booking> bookingsToday, int repairDuration,int dailyLimit) {
        int totalDurationForDay = repairDuration;// Randevu alınan repair saati

        for(Booking bookings : bookingsToday){
            totalDurationForDay += bookings.getRepair().getDuration();
        }
        return totalDurationForDay <= dailyLimit;
    }

    public Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

}
