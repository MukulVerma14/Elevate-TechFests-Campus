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
                    "Welcome to the Knowledge Services Exchange! Your " + formattedRole
                    + " profile has been successfully created.\n\n" +
                    "You can now log in to your dashboard to start exploring the platform.\n\n" +
                    "Best Regards,\nThe Millionminds Team";

            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            // Log the error, but do not throw it.
            // If the email fails to send, we don't want it to crash the user's
            // registration.
            System.err.println("Failed to send welcome email to " + toEmail + ": " + e.getMessage());
        }
    }

    @Async
    public void sendEoiNotificationToCampus(String campusEmail, String campusName,
            String companyName, String programmeName) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(campusEmail);
            message.setSubject("New Interest Expressed in Your Programme – " + programmeName);

            String body = "Hi " + campusName + ",\n\n" +
                    companyName + " has expressed interest in your programme: \"" + programmeName + "\".\n\n" +
                    "Log in to your KSEP dashboard to review their profile and decide on next steps.\n\n" +
                    "Best Regards,\nThe Millionminds Team";

            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send EOI notification: " + e.getMessage());
        }
    }

    @Async
    public void sendDealClosureNotification(String campusEmail, String campusName,
            String corporateEmail, String companyName,
            String programmeName) {
        try {
            // Notify Campus
            SimpleMailMessage campusMessage = new SimpleMailMessage();
            campusMessage.setFrom(fromEmail);
            campusMessage.setTo(campusEmail);
            campusMessage.setSubject("Deal Closed – " + programmeName);

            campusMessage.setText("Hi " + campusName + ",\n\n" +
                    "Great news! Your deal with " + companyName + " for the programme \"" +
                    programmeName + "\" has been successfully closed.\n\n" +
                    "Log in to your dashboard to view the deliverables.\n\n" +
                    "Best Regards,\nThe Millionminds Team");

            mailSender.send(campusMessage);

            // Notify Corporate
            SimpleMailMessage corporateMessage = new SimpleMailMessage();
            corporateMessage.setFrom(fromEmail);
            corporateMessage.setTo(corporateEmail);
            corporateMessage.setSubject("Deal Closed – " + programmeName);

            corporateMessage.setText("Hi " + companyName + ",\n\n" +
                    "Great news! Your deal for the programme \"" + programmeName +
                    "\" has been successfully closed.\n\n" +
                    "Log in to your dashboard to view the deliverables.\n\n" +
                    "Best Regards,\nThe Millionminds Team");

            mailSender.send(corporateMessage);

        } catch (Exception e) {
            System.err.println("Failed to send deal closure notifications: " + e.getMessage());
        }
    }
}