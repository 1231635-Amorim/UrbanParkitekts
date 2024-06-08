package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateTaskController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.CreateTaskUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * AdminUI class.
 * This class represents the user interface for administrators.
 */
public class AdminUI implements Runnable {

    /**
     * Runs the AdminUI.
     */
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Task for Collaborator", this::createTaskForCollaborator));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- ADMIN MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

    /**
     * Displays options to create a task for a collaborator.
     */
    private void createTaskForCollaborator() {
        CollaboratorRepository collaboratorRepository = Repositories.getInstance().getCollaboratorRepository();
        List<Collaborator> collaborators = collaboratorRepository.getAllCollaborators();

        if (collaborators.isEmpty()) {
            System.out.println("There are no collaborators available.");
            return;
        }

        System.out.println("Select a collaborator:");
        for (int i = 0; i < collaborators.size(); i++) {
            System.out.println((i + 1) + ". " + collaborators.get(i).getName());
        }

        int selectedCollaboratorIndex = Integer.parseInt(Utils.readLineFromConsole("Enter the number of the collaborator: ")) - 1;

        if (selectedCollaboratorIndex < 0 || selectedCollaboratorIndex >= collaborators.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Collaborator selectedCollaborator = collaborators.get(selectedCollaboratorIndex);

        CreateTaskController controller = new CreateTaskController();
        CreateTaskUI createTaskUI = new CreateTaskUI();
        createTaskUI.run();
    }
}
