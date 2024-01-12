package com.ismail.computerservice.dto;

import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CreateProposalDto {

    private String note;
    private Double price;
    private Long userId;
    private Boolean status;
    private Long productId;

    public CreateProposalDto(String note, Double price, Long userId, Boolean status, Long productId) {
        this.note = note;
        this.price = price;
        this.userId = userId;
        this.status = status;
        this.productId = productId;
    }

    public CreateProposalDto() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
