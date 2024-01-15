package com.ismail.computerservice.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="\"BOOKING\"")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "note")
    private String note;
    @Column(name = "booking_date")
    private Date bookingDate;
    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false)
    private Repair repair;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Booking(Long id, String note, Date bookingDate, Boolean status, Repair repair, User user) {
        this.id = id;
        this.note = note;
        this.bookingDate = bookingDate;
        this.status = status;
        this.repair = repair;
        this.user = user;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                ", repair=" + repair +
                ", user=" + user +
                '}';
    }
}
