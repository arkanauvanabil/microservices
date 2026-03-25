package com.arkan.Order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;

import com.arkan.Order.Repository.OrderRepository;
import com.arkan.Order.model.Order;
import com.arkan.Order.vo.Produk;
import com.arkan.Order.vo.ResponseTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    // ================= GET =================
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // ================= CREATE =================
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // ================= UPDATE =================
    public void updateOrder(Long orderId, Integer jumlah, String tanggal, String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order tidak ditemukan"));

        if (jumlah != null) {
            order.setJumlah(jumlah);
        }

        if (tanggal != null && !tanggal.isEmpty()) {
            order.setTanggal(tanggal);
        }



        orderRepository.save(order);
    }

    
     public List<ResponseTemplate> getOrderWithProdukById(Long id){
        List<ResponseTemplate> resoponseList = new ArrayList<>();
        Order order = getOrderById(id);
        ServiceInstance serviceInstance = discoveryClient.getInstances("PRODUK").get(0);
        Produk produk = restTemplate.getForObject(serviceInstance.getUri() + "/api/produk/"
                + order.getProductId(), Produk.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduk(produk);
        resoponseList.add(vo);
        return resoponseList;
    }

    // ================= DELETE =================
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}