package com.ismail.computerservice.dto;

import java.time.LocalDate;

public class CreateBookingDto {
    private String note;
    private LocalDate bookingDate;
    private Boolean status;
    private Long repairId;
    private Long userId;

    public CreateBookingDto(String note, LocalDate bookingDate, Boolean status, Long repairId, Long userId) {
        this.note = note;
        this.bookingDate = bookingDate;
        this.status = status;
        this.repairId = repairId;
        this.userId = userId;
    }

    public CreateBookingDto() {

    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
