package com.arkan.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkan.product.model.Produk;

@Repository

public interface ProdukRepository extends JpaRepository<Produk, Long>{




    
} 
