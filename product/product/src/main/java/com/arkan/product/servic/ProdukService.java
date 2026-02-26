package com.arkan.product.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkan.product.Repository.ProdukRepository;
import com.arkan.product.model.Produk;

@Service

public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;
    public List<Produk> getAllProduks(){
        return produkRepository.findAll();
    }
    public Produk getProdukByid(Long id ){
        return produkRepository.findById(id).orElse(null);
    }

    public Produk createProduk(Produk produk){
        return produkRepository.save(produk);
    }

    public void deleteProduk (Long id){
        produkRepository.deleteById(id);
    }

}
