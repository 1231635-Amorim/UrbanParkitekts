package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.EmailService23;

public class DEIEmailService implements EmailService23 {
    public void sendEmail(String to, String subject, String message) {
        // Implementar o envio de email usando o serviço do DEI
        System.out.println("Sending email via DEI to " + to + ": " + subject + " - " + message);
    }
}
