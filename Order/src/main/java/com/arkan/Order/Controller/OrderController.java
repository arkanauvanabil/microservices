package com.arkan.Order.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arkan.Order.model.Order;
import com.arkan.Order.service.OrderService;
import com.arkan.Order.vo.ResponseTemplate;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrder();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/produk/{id}")
    public List<ResponseTemplate> getOrderWithProdukById(@PathVariable Long id) {
        return orderService.getOrderWithProdukById(id);
    }

    @PutMapping("/{id}")
    public void updateOrder(
            @PathVariable Long id,
            @RequestParam(required = false) Integer jumlah,
            @RequestParam(required = false) String tanggal,
            @RequestParam(required = false) String status) {

        // ✅ FIX: pakai object, bukan class
        // ✅ FIX: nama method harus sesuai service
        orderService.updateOrder(id, jumlah, tanggal, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}