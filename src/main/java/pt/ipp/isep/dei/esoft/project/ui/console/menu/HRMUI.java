/**
 * The HRMUI class provides a console-based user interface for HR managers.
 * It presents a menu with options such as registering skills, jobs, collaborators, generating team proposals, and listing collaborators.
 * Each option is associated with a specific UI component.
 * HR managers can select an option from the menu to perform the corresponding action.
 *
 * @author [João Amorim]
 */

package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.*;

import java.util.ArrayList;
import java.util.List;

public class HRMUI implements Runnable {

    /**
     * Constructs an HRMUI.
     */
    public HRMUI() {
    }

    /**
     * Runs the HR manager menu.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a skill", new RegisterSkillUI()));
        options.add(new MenuItem("Register a job", new RegisterJobUI()));
        options.add(new MenuItem("Register Collaborator", new RegisterCollaboratorUI()));
        options.add(new MenuItem("Generate Team Proposal", new GenerateTeamProposalUI()));
        options.add(new MenuItem("List Collaborators", new ListCollaboratorsUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- HR MANAGER MENU ---------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
