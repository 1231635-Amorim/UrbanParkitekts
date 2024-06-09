package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Agenda;
import pt.ipp.isep.dei.esoft.project.domain.AgendaEntry;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private final Agenda agenda;
    private final GreenSpaceRepository greenSpaceRepository;

    public AgendaController() {
        this.agenda = new Agenda();
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

    public void addAgendaEntry(ToDoEntry toDoEntry, String team, String vehiclesEquipment, String timeInterval, LocalDate date, String status) {
        AgendaEntry entry = new AgendaEntry(toDoEntry, team, vehiclesEquipment, timeInterval, date, status);
        agenda.addEntry(entry);
    }

    public List<ToDoEntry> getToDoListEntries(String userEmail, String greenSpaceName) {
        return agenda.getEntriesByUserAndGreenSpace(userEmail, greenSpaceName);
    }

    public List<GreenSpace> getGreenSpaces(String userEmail) {
        return greenSpaceRepository.getGreenSpacesByUserEmail(userEmail);
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public List<AgendaEntry> getAllAgendaEntries() {
        return new ArrayList<>(agenda.getEntries());
    }
}
