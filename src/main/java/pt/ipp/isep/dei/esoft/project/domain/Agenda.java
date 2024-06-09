package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agenda {

    private List<AgendaEntry> entries;

    public Agenda() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(AgendaEntry entry) {
        entries.add(entry);
    }

    public List<AgendaEntry> getEntries() {
        return entries;
    }



    public List<ToDoEntry> getEntriesByUserAndGreenSpace(String userEmail, String greenSpaceName) {
        List<ToDoEntry> userEntries = new ArrayList<>();
        for (AgendaEntry entry : entries) {
            ToDoEntry toDoEntry = entry.getToDoEntry();
            if (toDoEntry.getUserEmail().equals(userEmail) && toDoEntry.getGreenSpaceName().equals(greenSpaceName)) {
                userEntries.add(toDoEntry);
            }
        }
        return userEntries;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "entries=" + entries +
                '}';
    }
}
