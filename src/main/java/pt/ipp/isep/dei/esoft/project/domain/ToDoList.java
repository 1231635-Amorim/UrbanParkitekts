package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<ToDoEntry> entries;

    public ToDoList() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(ToDoEntry entry) {
        entries.add(entry);
    }

    public List<ToDoEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    public void setEntries(List<ToDoEntry> entries) {
        this.entries = entries;
    }
}
