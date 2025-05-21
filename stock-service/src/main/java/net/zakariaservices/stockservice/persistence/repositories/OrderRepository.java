package net.zakariaservices.stockservice.persistence.repositories;

import net.zakariaservices.stockservice.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
