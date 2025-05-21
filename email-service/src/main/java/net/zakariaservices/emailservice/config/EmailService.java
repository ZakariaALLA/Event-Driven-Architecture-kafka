package net.zakariaservices.emailservice.config;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
