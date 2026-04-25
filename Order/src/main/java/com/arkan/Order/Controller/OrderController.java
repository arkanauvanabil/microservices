package com.arkan.Order.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import com.arkan.Order.model.Order;
import com.arkan.Order.service.OrderService;
import com.arkan.Order.vo.ResponseTemplate;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 🔥 GET ALL ORDER + USER LOGIN
    @GetMapping
    public List<Order> getAllOrders(Authentication auth) {

        String username = auth.getName();
        System.out.println("USER LOGIN: " + username);

        return orderService.getAllOrder();
    }


    @PostMapping
public Order createOrder(@RequestBody Order order) {
    return orderService.createOrder(order);
}

    // GET BY ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // GET PRODUK
    @GetMapping("/produk/{id}")
    public List<ResponseTemplate> getOrderWithProdukById(@PathVariable Long id) {
        return orderService.getOrderWithProdukById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public void updateOrder(
            @PathVariable Long id,
            @RequestParam(required = false) Integer jumlah,
            @RequestParam(required = false) String tanggal,
            @RequestParam(required = false) String status) {

        orderService.updateOrder(id, jumlah, tanggal, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}