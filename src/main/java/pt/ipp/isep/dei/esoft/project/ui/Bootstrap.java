package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.time.format.DateTimeFormatter;






public class Bootstrap implements Runnable {

    public void run() {
        addTaskCategories();
        addOrganization();
        addUsers();
        addJobs();
        addCollaborators();
        addGreenspaces();
    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organization.addEmployee(new Employee("hrm@this.app"));
        organization.addEmployee(new Employee("gsm@this.app"));
        organization.addEmployee(new Employee("collaborator@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HUMANRESOURCESMANAGER, AuthenticationController.ROLE_HUMANRESOURCESMANAGER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_COLLABORATOR, AuthenticationController.ROLE_COLLABORATOR);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd", AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserWithRole("Human Resource Manager", "hrm@this.app", "hrm", AuthenticationController.ROLE_HUMANRESOURCESMANAGER);

        authenticationRepository.addUserWithRole("GSM", "gsm@this.app", "gsm", AuthenticationController.ROLE_GSM);

        authenticationRepository.addUserWithRole("Collaborator", "collaborator@this.app", "collaborator", AuthenticationController.ROLE_COLLABORATOR);
    }

    /**
     * Adds collaborators to the repository.
     */
    private void addCollaborators() {
        CollaboratorRepository collaboratorRepository = Repositories.getInstance().getCollaboratorRepository();
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_COLLABORATOR, AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Maria Oliveira", LocalDate.of(1986, 5, 20), LocalDate.of(2010, 8, 15), "Rua das Flores, nº 234, 4050-417 Porto", "912345678", "maria.oliveira@gmail.com", 987654321, 12345678, "Gardener"));
        authenticationRepository.addUserWithRole("Collaborator", "maria.oliveira@gmail.com", "12345678", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Rui Silva", LocalDate.of(1980, 12, 10), LocalDate.of(2008, 7, 20), "Avenida dos Aliados, nº 567, 1000-021 Lisboa", "934567890", "rui.silva@gmail.com", 987654322, 87654321, "Arborist"));
        authenticationRepository.addUserWithRole("Collaborator", "rui.silva@gmail.com", "87654321", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Catarina Santos", LocalDate.of(1990, 3, 15), LocalDate.of(2015, 6, 30), "Rua das Palmeiras, nº 345, 3000-450 Coimbra", "920987654", "catarina.santos@gmail.com", 987654323, 98765432, "Urban Planner"));
        authenticationRepository.addUserWithRole("Collaborator", "catarina.santos@gmail.com", "98765432", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Diogo Ferreira", LocalDate.of(1982, 9, 5), LocalDate.of(2011, 4, 25), "Travessa das Oliveiras, nº 678, 5000-700 Vila Real", "917654321", "diogo.ferreira@gmail.com", 987654324, 21098765, "Park Ranger"));
        authenticationRepository.addUserWithRole("Collaborator", "diogo.ferreira@gmail.com", "21098765", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Inês Rodrigues", LocalDate.of(1985, 7, 20), LocalDate.of(2013, 2, 10), "Rua das Amendoeiras, nº 789, 2000-400 Santarém", "925432109", "ines.rodrigues@gmail.com", 987654325, 87654321, "Park Ranger"));
        authenticationRepository.addUserWithRole("Collaborator", "ines.rodrigues@gmail.com", "87654321", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Filipe Gomes", LocalDate.of(1983, 6, 30), LocalDate.of(2012, 8, 20), "Avenida Central, nº 890, 1000-300 Lisboa", "925432108", "filipe.gomes@gmail.com", 987654326, 87654322, "Park Ranger"));
        authenticationRepository.addUserWithRole("Collaborator", "filipe.gomes@gmail.com", "87654322", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Carla Ribeiro", LocalDate.of(1977, 8, 25), LocalDate.of(2005, 6, 15), "Rua das Figueiras, nº 456, 4050-001 Porto", "925432107", "carla.ribeiro@gmail.com", 987654327, 87654323, "Park Ranger"));
        authenticationRepository.addUserWithRole("Collaborator", "carla.ribeiro@gmail.com", "87654323", AuthenticationController.ROLE_COLLABORATOR);
        collaboratorRepository.add(new Collaborator("Bruno Fernandes", LocalDate.of(1988, 4, 10), LocalDate.of(2014, 9, 5), "Largo da Sé, nº 123, 3000-200 Coimbra", "925432106", "bruno.fernandes@gmail.com", 987654328, 87654324, "Park Ranger"));
        authenticationRepository.addUserWithRole("Collaborator", "bruno.fernandes@gmail.com", "87654324", AuthenticationController.ROLE_COLLABORATOR);
    }

    /**
     * Adds jobs to the repository.
     */
    private void addJobs() {
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();
        jobRepository.add(new Job("Gardener"));
        jobRepository.add(new Job("Arborist"));
        jobRepository.add(new Job("Park Ranger"));
        jobRepository.add(new Job("Urban Planner"));
    }

    private void addGreenspaces() {
        GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();


        greenSpaceRepository.addGreenSpace(new Garden("Jardim do Covelo", 1000, "gsm@this.app"));
        greenSpaceRepository.addGreenSpace(new MediumSizedPark("Parque das Planicies", 10313200, "gsm@this.app"));
        greenSpaceRepository.addGreenSpace(new LargeSizedPark("Parque das virtudes", 123100, "gsm@this.app"));
        greenSpaceRepository.addGreenSpace(new Garden("Exposende", 103200, "gsm@this.app"));
        greenSpaceRepository.addGreenSpace(new MediumSizedPark("Parque Urbano de ermesinde", 1000, "gsm@this.app"));
        greenSpaceRepository.addGreenSpace(new LargeSizedPark("parque gigante", 324242, "gsm@this.app"));

    }

}