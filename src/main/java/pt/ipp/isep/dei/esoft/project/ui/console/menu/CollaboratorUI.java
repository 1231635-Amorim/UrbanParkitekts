package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.DisplayTasksUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.RegisterGreenSpaceUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The CollaboratorUI class represents the user interface for collaborator-related actions.
 */
public class CollaboratorUI implements Runnable {

    private final String userEmail;

    /**
     * Constructs a new CollaboratorUI with the given user email.
     *
     * @param userEmail the email of the collaborator accessing the interface
     */
    public CollaboratorUI(String userEmail) {
        GreenSpaceRepository greenSpaceRepository = new GreenSpaceRepository();
        this.userEmail = userEmail;
    }

    /**
     * Runs the collaborator user interface.
     */
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Consult my tasks", new DisplayTasksUI(userEmail)));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- Collaborator Menu -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
