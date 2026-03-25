package com.arkan.Order.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long productId;

    private String tanggal;

    private int jumlah;

    private double total;
}