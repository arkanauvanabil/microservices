package arkan.Order.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import arkan.Order.model.Order;
import arkan.Order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController  {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}