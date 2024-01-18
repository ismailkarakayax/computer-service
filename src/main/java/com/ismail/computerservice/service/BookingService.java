package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateBookingDto;
import com.ismail.computerservice.model.Booking;
import com.ismail.computerservice.model.Repair;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.BookingRepository;
import com.ismail.computerservice.repository.RepairRepository;
import com.ismail.computerservice.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        Repair repair= getRepairById(createBookingDto.getRepairId());

        //Randevu alan User getir
        User user = getUserById(createBookingDto.getUserId());

        //Randevu alınan tarihdeki tüm bookingdateleri getir
        List<Booking> bookingsLastDay= getBookingsLastDay();

        //Dtoları gir
        Booking booking = createBookingEntity(createBookingDto, repair, user);

        //O gün alınan toplam randevu süresi 10 saati geçiyor mu
        int dailyLimit = 10;

        if(!isTotalDurationWithinLimit(bookingsLastDay,repair.getDuration(), dailyLimit)) {
            // Try to book for the next day
            Date nextAvaliableDate = getNextDay(bookingRepository.findMaxBookingDate());
            List<Booking> bookingsNextDay = bookingRepository.findByBookingDate(nextAvaliableDate);

            // Bir sonraki güne de randevu alabiliyorsa, tarihi güncelle
            if (isTotalDurationWithinLimit(bookingsNextDay, repair.getDuration(), dailyLimit)) {
                booking.setBookingDate(nextAvaliableDate);
            } else {
                throw new IllegalArgumentException("Cannot book appointment due to exceeding the daily limit");
            }
        }
        return bookingRepository.save(booking);
    }

    //Repairid ye göre repair nesnesini bulur
    private Repair getRepairById(Long repairId) {
        return repairRepository.findById(repairId)
                .orElseThrow(() -> new RuntimeException("Repair not found"));
    }

    //Userid ye göre user nesnesini bulur
    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    private Booking updateBookingStatus(Long bookingId, boolean status) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    //En güncel tarihdeki tüm randevuları getirir
    private List<Booking> getBookingsLastDay(){
        return bookingRepository.findBookingsOnLastDay();
    }

    //Booking nesnesini oluştur
    private Booking createBookingEntity(CreateBookingDto createBookingDto, Repair repair, User user) {
        Booking booking = new Booking();
        booking.setNote(createBookingDto.getNote());
        booking.setBookingDate(bookingRepository.findMaxBookingDate());
        booking.setStatus(false);
        booking.setRepair(repair);
        booking.setUser(user);
        return booking;
    }

    //Yarın metodu
    public Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }


    //O gün alınan toplam randevu şüresi 10 saati geçiyor mu metodu
    public boolean isTotalDurationWithinLimit(List<Booking> bookingsToday, int repairDuration,int dailyLimit) {
        int totalDurationForDay = repairDuration;// Randevu alınan repair saati

        for(Booking bookings : bookingsToday){
            totalDurationForDay += bookings.getRepair().getDuration();
        }
        return totalDurationForDay <= dailyLimit;
    }
}





