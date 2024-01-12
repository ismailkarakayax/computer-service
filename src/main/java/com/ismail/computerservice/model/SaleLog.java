package com.ismail.computerservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="\"SALE_LOG\"")
public class SaleLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sale_log_date")
    private LocalDateTime date;

    @Column(name = "credit_card", length = 20)
    private String creditCard;

    @OneToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public SaleLog(Long id, LocalDateTime date, String creditCard, Sale sale, User user) {
        this.id = id;
        this.date = date;
        this.creditCard = creditCard;
        this.sale = sale;
        this.user = user;
    }

    public SaleLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SaleLog{" +
                "id=" + id +
                ", date=" + date +
                ", creditCard='" + creditCard + '\'' +
                ", sale=" + sale +
                ", user=" + user +
                '}';
    }
}
