package net.zakariaservices.orderservice.controller;

import net.zakariaservices.basedomains.dto.Order;
import net.zakariaservices.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        return this.orderService.processOrder(order);
    }
}
