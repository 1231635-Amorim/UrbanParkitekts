package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.util.Random;

public class EmailService {
    public void sendEmail(String recipientEmail, String subject, String message) {
        System.out.println("Sending email to: " + recipientEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }

    public void sendPasswordByEmail(String recipientEmail) {
        String password = generatePassword();
        String subject = "Your New Password";
        String message = "Your new password is: " + password;
        sendEmail(recipientEmail, subject, message);
    }

    private String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[{]};:',<.>/?";

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }
}
