package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.RegisterSkillUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HRMUI implements Runnable {

    public HRMUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a skill",new RegisterSkillUI()));
        options.add(new MenuItem("Generate Team Proposal", new GenerateTeamProposalUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- HR MANAGER MENU ---------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

