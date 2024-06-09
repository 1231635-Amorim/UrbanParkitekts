package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.EmailService23;

public class GmailService implements EmailService23 {

    public void sendEmail(String to, String subject, String message) {
        System.out.println("Sending email via Gmail to " + to + ": " + subject + " - " + message);
    }

}
