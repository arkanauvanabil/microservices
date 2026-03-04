package arkan.Order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arkan.Order.Repository.OrderRepository;
import arkan.Order.model.Order;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public arkan.Order.model.Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public arkan.Order.model.Order createOrder(arkan.Order.model.Order order){

        order.setTotal(order.getHarga() * order.getJumlah());

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}