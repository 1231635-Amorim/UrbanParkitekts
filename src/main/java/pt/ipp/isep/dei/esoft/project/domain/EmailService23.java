package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.EmailService;

public interface EmailService23 {

    void sendEmail(String recipient, String subject, String body);

    public class GmailService implements EmailService23 {

        public void sendEmail(String recipient, String subject, String body) {
            // Implementação para enviar e-mail usando o serviço Gmail
        }
    }

    public class DEIEmailService implements EmailService23 {

        public void sendEmail(String recipient, String subject, String body) {
            // Implementação para enviar e-mail usando o serviço DEI
        }
    }


}

