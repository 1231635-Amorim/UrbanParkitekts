/**
 * The RegisterCollaboratorController class is responsible for registering new collaborators
 and validating their information.
 * It interacts with CollaboratorRepository to persist the new collaborators and EmailService to send them passwords.
 * This class ensures that the provided information is valid before registering a new collaborator.
 * @author [João Amorim]
 */

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

    /**
     * Registers a new collaborator.
     *
     * @param name           The name of the collaborator.
     * @param birthDate      The birth date of the collaborator.
     * @param admissionDate  The admission date of the collaborator.
     * @param address        The address of the collaborator.
     * @param mobile         The mobile phone number of the collaborator.
     * @param email          The email address of the collaborator.
     * @param taxpayerNumber The taxpayer number of the collaborator.
     * @param idDocType      The type of identification document.
     * @param idNumber       The identification number.
     * @param job            The job position of the collaborator.
     * @return A string indicating the success or failure of the operation.
     */
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

    /**
     * Checks if the provided email is in a valid format.
     *
     * @param email The email address to validate.
     * @return True if the email is valid, false otherwise.
     */
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Checks if the provided phone number is in a valid format.
     *
     * @param phoneNumber The phone number to validate.
     * @return True if the phone number is valid, false otherwise.
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{9}");
    }

    /**
     * Checks if the provided birth date indicates the collaborator is at least 18 years old.
     *
     * @param birthDate The birth date of the collaborator.
     * @return True if the birth date is valid, false otherwise.
     */
    private boolean isValidBirthDate(Date birthDate) {
        Date today = new Date();
        Date eighteenYearsAgo = new Date(today.getYear() - 18, today.getMonth(), today.getDate());
        return birthDate.before(eighteenYearsAgo);
    }

    /**
     * Checks if the provided identification number is in a valid format.
     *
     * @param idDocType The type of identification document.
     * @param idNumber  The identification number to validate.
     * @return True if the ID number is valid, false otherwise.
     */
    private boolean isValidIDNumber(String idDocType, String idNumber) {
        return idNumber.length() >= 6;
    }

    /**
     * Generates a random password for the collaborator.
     *
     * @return A randomly generated password.
     */
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

