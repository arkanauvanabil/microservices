package com.arkan.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arkan.product.model.Produk;
import com.arkan.product.service.ProdukService;

@RestController
@RequestMapping("/api/produk")

public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAllProduk(){
        return produkService.getAllProduks();
    }

    @PostMapping
    public Produk createProduk(@RequestBody Produk produk){
        return produkService.createProduk(produk);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable Long id){
        Produk produk = produkService.getProdukByid(id);
        return produk != null ? ResponseEntity.ok(produk) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduk(@PathVariable Long id){
        produkService.deleteProduk(id);
        return ResponseEntity.ok().build();
    }
}