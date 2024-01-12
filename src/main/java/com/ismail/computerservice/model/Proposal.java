package com.ismail.computerservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"PROPOSAL\"")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "note")
    private String note;
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    public Proposal(Long id, String note, Double price, User user, Boolean status, Product product) {
        this.id = id;
        this.note = note;
        this.price = price;
        this.user = user;
        this.status = status;
        this.product = product;
    }
    public Proposal() {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
