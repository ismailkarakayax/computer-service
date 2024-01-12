package com.ismail.computerservice.dto;

public class CreateProductDto {

    private String name;

    public CreateProductDto(String name) {
        this.name = name;
    }

    public CreateProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
