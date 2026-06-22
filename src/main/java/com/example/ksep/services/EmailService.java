package com.example.ksep.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Async
    public void sendWelcomeEmail(String toEmail, String name, String role) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject("Welcome to Millionminds KSEP!");

            String formattedRole = role.equals("CAMPUS") ? "Campus" : "Corporate";

            String body = "Hi " + name + ",\n\n" +
                    "Welcome to the Knowledge Services Exchange! Your " + formattedRole + " profile has been successfully created.\n\n" +
                    "You can now log in to your dashboard to start exploring the platform.\n\n" +
                    "Best Regards,\nThe Millionminds Team";

            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            // Log the error, but do not throw it.
            // If the email fails to send, we don't want it to crash the user's registration.
            System.err.println("Failed to send welcome email to " + toEmail + ": " + e.getMessage());
        }
    }
}