package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import java.time.LocalDate;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * The {@code RegisterCollaboratorController} class represents a controller responsible for managing
 * the registration of collaborators in the application.
 * It interacts with the collaborator repository to add new collaborators and perform validation checks.
 */
public class RegisterCollaboratorController {

    private final CollaboratorRepository collaboratorRepository;

    /**
     * Constructs a new {@code RegisterCollaboratorController} object.
     * Initializes the collaborator repository.
     */
    public RegisterCollaboratorController() {
        Repositories repositories = Repositories.getInstance();
        this.collaboratorRepository = repositories.getCollaboratorRepository();
    }

    /**
     * Creates a new collaborator with the provided information.
     * Adds the collaborator to the repository if it is valid and does not already exist.
     *
     * @param name           The name of the collaborator.
     * @param birthDate      The birthday date of the collaborator.
     * @param admissionDate  The admission date of the collaborator.
     * @param address        The address of the collaborator.
     * @param phoneNumber    The phone number of the collaborator.
     * @param email          The email address of the collaborator.
     * @param taxpayerNumber The taxpayer number of the collaborator.
     * @param biNumber       The BI number of the collaborator.
     * @param job            The job of the collaborator.
     * @return An optional containing the newly created collaborator, if successful.
     */
    public Collaborator registerCollaborator(String name, LocalDate birthDate, LocalDate admissionDate,
                                             String address, String phoneNumber, String email,
                                             int taxpayerNumber, long biNumber, String job) {
        Collaborator collaborator = new Collaborator(name, birthDate, admissionDate,
                address, phoneNumber, email, taxpayerNumber, biNumber, job);

        return collaboratorRepository.add(collaborator);
    }


    /**
     * Retrieves a list of all collaborators.
     *
     * @return A list of collaborators.
     */
    public List<Collaborator> getCollaboratorsList() {
        return collaboratorRepository.getAllCollaborators();
    }

    /**
     * Retrieves a list of available jobs for collaborators.
     *
     * @return A list of available jobs.
     */
    public List<Job> getAvailableJobs() {
        RegisterJobController registerJobController = new RegisterJobController();
        return registerJobController.getJobList();
    }

    /**
     * Checks if the provided taxpayer number already exists for another collaborator.
     *
     * @param taxpayerNumber The taxpayer number to check.
     * @return {@code true} if the taxpayer number is a duplicate, {@code false} otherwise.
     */
    public boolean isTaxpayerNumberDuplicate(int taxpayerNumber) {
        List<Collaborator> collaborators = collaboratorRepository.getAllCollaborators();
        for (Collaborator collaborator : collaborators) {
            if (collaborator.getTaxpayerNumber() == taxpayerNumber) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the provided BI number already exists for another collaborator.
     *
     * @param biNumber The BI number to check.
     * @return {@code true} if the BI number is a duplicate, {@code false} otherwise.
     */
    public boolean isBINumberDuplicate(long biNumber) {
        List<Collaborator> collaborators = collaboratorRepository.getAllCollaborators();
        for (Collaborator collaborator : collaborators) {
            if (collaborator.getBINumber() == biNumber) {
                return true;
            }
        }
        return false;
    }

}
