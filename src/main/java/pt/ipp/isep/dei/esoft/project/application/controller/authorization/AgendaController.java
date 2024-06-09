package pt.ipp.isep.dei.esoft.project.application.controller.authorization;



    import pt.ipp.isep.dei.esoft.project.domain.Agenda;
    import pt.ipp.isep.dei.esoft.project.domain.AgendaEntry;
    import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;

    import java.time.LocalDate;

public class AgendaController {
    private final Agenda agenda;

    public AgendaController() {
        this.agenda = new Agenda();
    }

    public void addAgendaEntry(ToDoEntry toDoEntry, String team, String vehiclesEquipment, String timeInterval, LocalDate date, String status) {
        AgendaEntry entry = new AgendaEntry(toDoEntry, team, vehiclesEquipment, timeInterval, date, status);
        agenda.addEntry(entry);
    }
    public Agenda getAgenda() {
        return agenda;
    }
}


