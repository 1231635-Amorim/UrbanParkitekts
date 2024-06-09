package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import pt.ipp.isep.dei.esoft.project.domain.Agenda;

public class AddNewEntryAgendaController {

    private final GreenSpaceRepository greenSpaceRepository;
    private final Agenda agenda;
    private final ToDoList toDoList;
    private final AgendaController agendaController;


    public AddNewEntryAgendaController() {
        this.greenSpaceRepository = new GreenSpaceRepository();
        this.agenda = new Agenda();
        this.toDoList = new ToDoList();
        this.agendaController = new AgendaController();

    }




    public void addAgendaEntry(ToDoEntry selectedToDoEntry, Team team, String vehiclesEquipment, String timeInterval, LocalDate date, String status) {
        // Verificar se a entrada está na ToDo List antes de adicionar à Agenda
        if (toDoList.contains(selectedToDoEntry)) {
            // Adicionar entrada à Agenda
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

    // Método para obter a ToDoList
    public ToDoList getToDoList() {
        return toDoList;
    }


    // Método para enviar mensagem de atribuição para a equipe
    private void sendAssignmentMessage(Team team, AgendaEntry entry) {
        // Lógica para atribuir uma equipe a uma entrada na agenda
        // Envio de mensagem para a equipe
        List<String> memberEmails = team.getMemberEmails();
        String message = "Você foi atribuído a uma nova tarefa na agenda.";
        for (String email : memberEmails) {
            DEIEmailService emailService = null;
            emailService.sendEmail(email, "Nova Tarefa na Agenda", message);
        }
    }

    public void assignTeamToAgenda(AgendaEntry agendaEntry, Team team) {
    }
}






