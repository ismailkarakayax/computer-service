package com.ismail.computerservice.dto;

import com.ismail.computerservice.model.Product;

public class CreateSaleDto {

    private String note;
    private Double price;
    private String productName;

    public CreateSaleDto(String note, Double price, String productName) {
        this.note = note;
        this.price = price;
        this.productName = productName;
    }

    public CreateSaleDto() {
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
