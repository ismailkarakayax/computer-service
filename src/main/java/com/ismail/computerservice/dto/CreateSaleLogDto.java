package com.ismail.computerservice.dto;

import com.ismail.computerservice.model.Sale;
import com.ismail.computerservice.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

public class CreateSaleLogDto {


    private String creditCard;
    private Long saleId;  // Bu satırı ekledik
    private Long userId;

    public CreateSaleLogDto(String creditCard, Long saleId, Long userId) {
        this.creditCard = creditCard;
        this.saleId = saleId;
        this.userId = userId;
    }

    public CreateSaleLogDto() {
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
