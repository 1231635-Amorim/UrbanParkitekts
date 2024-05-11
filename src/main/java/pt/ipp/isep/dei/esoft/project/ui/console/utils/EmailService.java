package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.util.Random;

public class EmailService {
    public void sendPasswordByEmail(String recipientEmail) {
        String password = generatePassword();
        System.out.println("Sending email with password to " + recipientEmail);
        System.out.println("Your new password is: " + password);
    }

    private String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }
}


