package net.zakariaservices.emailservice.kafka;

import net.zakariaservices.basedomains.dto.OrderEvent;
import net.zakariaservices.emailservice.config.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private final EmailService emailService;

    public OrderConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event){
        LOGGER.info("Order event received in email service => {}", event.toString());

        String emailAdress = event.getOrder().getUserEmail();
        String emailSubject = String.format("Your Order %s Has Been Received", event.getOrder().getOrderId());
        String emailBody = String.format("""
                    Dear Customer,
                    Thank you for your order!
                    We’re happy to confirm that your order %s (%s) has been successfully received and is now awaiting processing. Our team will begin handling your request as soon as possible.
                    You’ll receive another notification as soon as your order has been shipped.
                    If you have any questions in the meantime, feel free to reach out to us.
                    Best regards,
                    """, event.getOrder().getName(), event.getOrder().getOrderId());
        emailService.sendEmail(emailAdress, emailSubject, emailBody);
    }
}
