package net.zakariaservices.emailservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServceImpl.class);

    @Value("${spring.mail.username}")
    private String senderEmail;

    private final JavaMailSender emailSender;

    public EmailServceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String text) {
        LOGGER.info("Start sending Email to user {}", to);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
        LOGGER.info("Email Sent to user {} with success", to);
    }
}
