package com.arkan.Order.vo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Produk {

    private Long id;

    private String nama;

    private String satuan;

    private BigDecimal harga;
}