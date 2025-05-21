package net.zakariaservices.orderservice.service;

import net.zakariaservices.basedomains.dto.Order;
import net.zakariaservices.basedomains.dto.OrderEvent;
import net.zakariaservices.orderservice.kafka.OrderProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderProducer orderProducer;

    public OrderService(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    public String processOrder(Order order) {

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully ...";
    }
}
