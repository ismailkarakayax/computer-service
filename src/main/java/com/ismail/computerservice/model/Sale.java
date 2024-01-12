package com.ismail.computerservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"SALE\"")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "note")
    private String note;
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;



    public Sale(Long id, String note, Double price, Product product ) {
        this.id = id;
        this.note = note;
        this.price = price;
        this.product = product;

    }

    public Sale() {
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

    public Product getProduct(Product product) {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", product=" + product +
                '}';
    }
}
