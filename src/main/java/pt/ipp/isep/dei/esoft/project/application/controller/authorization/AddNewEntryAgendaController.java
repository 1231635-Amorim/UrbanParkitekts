package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import pt.ipp.isep.dei.esoft.project.domain.Agenda;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.EmailService;

public class AddNewEntryAgendaController {

    private final GreenSpaceRepository greenSpaceRepository;
    private final Agenda agenda;
    private final ToDoList toDoList;
    private final AgendaController agendaController;
    private final EmailService emailService;

    public AddNewEntryAgendaController() {
        this.greenSpaceRepository = new GreenSpaceRepository();
        this.agenda = new Agenda();
        this.toDoList = new ToDoList();
        this.agendaController = new AgendaController();
        this.emailService = new EmailService();
    }

    public void addAgendaEntry(ToDoEntry selectedToDoEntry, String team, String vehiclesEquipment, String timeInterval, LocalDate date, String status) {
        if (toDoList.contains(selectedToDoEntry)) {
            agendaController.addAgendaEntry(selectedToDoEntry, team, vehiclesEquipment, timeInterval, date, status);
            System.out.println("Agenda entry added successfully.");
        } else {
            System.out.println("Error: The selected to-do entry does not exist in the to-do list.");
        }
    }

    public List<ToDoEntry> getPendingToDoEntries(String userEmail) {
        return toDoList.getPendingEntriesByUserEmail(userEmail);
    }

    public void addToDoEntry(String taskDescription, String userEmail, boolean pending) {
        ToDoEntry entry = new ToDoEntry(taskDescription, userEmail, pending);
        toDoList.addEntry(entry);
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void assignTeamToAgendaEntry(UUID agendaEntryId, String team) {
        AgendaEntry entry = agendaController.getAgenda().getEntryById(agendaEntryId);
        if (entry != null) {
            entry.setTeam(team);
            sendAssignmentMessage(team, entry);
            System.out.println("Team assigned to agenda entry successfully.");
        } else {
            System.out.println("Error: Agenda entry not found.");
        }
    }
    private void sendAssignmentMessage(String team, AgendaEntry entry) {
        String subject = "New Assignment: " + entry.getToDoEntry().getTaskDescription();
        String message = "You have been assigned to a new task: " + entry.getToDoEntry().getTaskDescription();
        emailService.sendEmail(team, subject, message);
    }

}





