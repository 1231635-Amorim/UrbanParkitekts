package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.EmailService;

import java.util.Date;

public class RegisterCollaboratorController {
    private CollaboratorRepository collaboratorRepository = new CollaboratorRepository();
    private EmailService emailService = new EmailService();

    public RegisterCollaboratorController() {
    }

    public String registerCollaborator(String name, Date birthDate, Date admissionDate, String address,
                                       String mobile, String email, String taxpayerNumber, String idDocType, String idNumber,
                                       Job job) {
        if (!isValidEmail(email)) {
            return "Invalid email format";
        }

        if (!isValidPhoneNumber(mobile)) {
            return "Invalid phone number format";
        }

        if (!isValidBirthDate(birthDate)) {
            return "Collaborator must be at least 18 years old";
        }

        if (!isValidIDNumber(idDocType, idNumber)) {
            return "Invalid ID document number format";
        }

        String password = generatePassword();

        Collaborator collaborator = new Collaborator(name, birthDate, admissionDate, address, mobile, email,
                taxpayerNumber, idDocType, idNumber, job, password);

        collaboratorRepository.add(collaborator);

        emailService.sendPasswordByEmail(collaborator.getEmail());

        return "Operation success";
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{9}");
    }

    private boolean isValidBirthDate(Date birthDate) {
        Date today = new Date();
        Date eighteenYearsAgo = new Date(today.getYear() - 18, today.getMonth(), today.getDate());
        return birthDate.before(eighteenYearsAgo);
    }

    private boolean isValidIDNumber(String idDocType, String idNumber) {
        return idNumber.length() >= 6;
    }

    private String generatePassword() {
        StringBuilder password = new StringBuilder();
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";

        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * uppercaseLetters.length());
            password.append(uppercaseLetters.charAt(randomIndex));
        }

        for (int i = 0; i < 2; i++) {
            int randomIndex = (int) (Math.random() * digits.length());
            password.append(digits.charAt(randomIndex));
        }

        return password.toString();
    }
}
