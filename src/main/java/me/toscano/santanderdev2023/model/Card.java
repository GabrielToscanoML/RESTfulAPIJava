package me.toscano.santanderdev2023.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    // Getters
    public Long getId() {return id;}
    public String getNumber() {return number;}
    public BigDecimal getLimit() {return limit;}

    // Setters
    public void setId(Long id) {this.id = id;}
    public void setNumber(String number) {this.number = number;}
    public void setLimit(BigDecimal limit) {this.limit = limit;}
}