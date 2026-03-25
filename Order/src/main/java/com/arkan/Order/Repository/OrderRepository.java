package com.arkan.Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkan.Order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}