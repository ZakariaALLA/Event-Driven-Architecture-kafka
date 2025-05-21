package net.zakariaservices.stockservice.kafka;

import net.zakariaservices.basedomains.dto.OrderEvent;
import net.zakariaservices.stockservice.mapper.OrderMapper;
import net.zakariaservices.stockservice.persistence.entities.OrderEntity;
import net.zakariaservices.stockservice.persistence.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderConsumer(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event) {
        LOGGER.info("Order event received in stock service => {}", event.toString());
        OrderEntity orderEntity = this.orderMapper.orderToOrderEntity(event.getOrder());
        this.orderRepository.save(orderEntity);
    }
}
