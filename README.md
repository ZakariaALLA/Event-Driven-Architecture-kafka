# Event Driven Architecture based on Microservices And Kafka

## Purpose

This project demonstrates an event driven microservices-based architecture for managing orders and stock. It uses **Spring Boot** for building the services and **Apache Kafka** for asynchronous communication between the services. The project is designed to showcase how to implement event-driven microservices with Kafka.

### Key Features:
- **Order Service**: Produces order events and sends them to a Kafka topic.
- **Stock Service**: Consumes order events from the Kafka topic and processes them.
- **Email Service**: Consumes order events from the Kafka topic and send email to customer.
- **base-domains Service**: Centralises the base domain of our application.

![Architecture of the app](/img/archetecture.png?raw=true)

---

## Prerequisites

- **Java**
- **Maven**
- **Kafka**
- **Intellij IDEA**
- **PostgreSQL**
---

