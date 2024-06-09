package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AddNewEntryAgendaController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.*;

import java.util.ArrayList;
import java.util.List;

public class GreenSpacesManagerUI implements Runnable {

    private final String userEmail;

    public GreenSpacesManagerUI(String userEmail) {
        this.userEmail = userEmail;
    }


    public void run() {
        AddNewEntryAgendaController addNewEntryController = new AddNewEntryAgendaController();
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register Green Space", new RegisterGreenSpaceUI(userEmail)));
        options.add(new MenuItem("Add To-Do Entry", new AddToDoEntryUI(userEmail)));
        options.add(new MenuItem("Add new entry in the Agenda", new AddNewAgendaUI(addNewEntryController)));
        options.add(new MenuItem("Assign Team to Agenda",new AssignTeamToAgendaEntryUI(addNewEntryController)));
        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- Green Space Manager Menu -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

    public static void main(String[] args) {
        GreenSpacesManagerUI greenSpacesManagerUI = new GreenSpacesManagerUI("sample@example.com");
        greenSpacesManagerUI.run();
    }
}
