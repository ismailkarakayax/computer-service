package com.ismail.computerservice.dto;

public class CreateRepairDto {

    private String description;
    private Integer duration;
    private Integer laptop;
    private Integer desktop;
    private Integer mac;

    public CreateRepairDto(String description, Integer duration, Integer laptop, Integer desktop, Integer mac) {
        this.description = description;
        this.duration = duration;
        this.laptop = laptop;
        this.desktop = desktop;
        this.mac = mac;
    }

    public CreateRepairDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getLaptop() {
        return laptop;
    }

    public void setLaptop(Integer laptop) {
        this.laptop = laptop;
    }

    public Integer getDesktop() {
        return desktop;
    }

    public void setDesktop(Integer desktop) {
        this.desktop = desktop;
    }

    public Integer getMac() {
        return mac;
    }

    public void setMac(Integer mac) {
        this.mac = mac;
    }
}
