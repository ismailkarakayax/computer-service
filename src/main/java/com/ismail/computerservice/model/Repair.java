package com.ismail.computerservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"SERVICE\"")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "duration")
    private Integer duration;
    @Column(name="laptop")
    private Integer laptop;
    @Column(name="desktop")
    private Integer desktop;
    @Column(name="mac")
    private Integer mac;

    public Repair(Long id, String description, Integer duration, Integer laptop, Integer desktop, Integer mac) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.laptop = laptop;
        this.desktop = desktop;
        this.mac = mac;
    }

    public Repair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", laptop=" + laptop +
                ", desktop=" + desktop +
                ", mac=" + mac +
                '}';
    }
}
