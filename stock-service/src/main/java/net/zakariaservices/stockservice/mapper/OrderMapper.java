package net.zakariaservices.stockservice.mapper;

import net.zakariaservices.basedomains.dto.Order;
import net.zakariaservices.stockservice.persistence.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity orderToOrderEntity(Order order);
}
