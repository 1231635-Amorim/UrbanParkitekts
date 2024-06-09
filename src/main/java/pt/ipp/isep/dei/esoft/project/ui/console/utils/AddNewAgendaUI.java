package pt.ipp.isep.dei.esoft.project.ui.console.utils;


    import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AddNewEntryAgendaController;
    import pt.ipp.isep.dei.esoft.project.domain.*;

    import java.time.LocalDate;
    import java.time.format.DateTimeParseException;
    import java.util.ArrayList;
    import java.util.List;
import java.util.Scanner;

    public class AddNewAgendaUI implements Runnable {

        private final AddNewEntryAgendaController controller;
        ;

        public AddNewAgendaUI(AddNewEntryAgendaController controller) {
            this.controller = controller;

        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n--- Add To-Do Entry ---");

            System.out.print("Enter task description: ");
            String taskDescription = scanner.nextLine();

            System.out.print("Enter user email: ");
            String userEmail = scanner.nextLine();

            System.out.print("Is the task pending? (true/false): ");
            boolean pending = Boolean.parseBoolean(scanner.nextLine());

            controller.addToDoEntry(taskDescription, userEmail, pending);
            System.out.println("New entry added to the Agenda successfully.");
        }


    }


