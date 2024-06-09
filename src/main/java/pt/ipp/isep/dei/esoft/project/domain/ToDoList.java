package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<ToDoEntry> entries;

    /**
     * creates an array list with the entries
     */

    public ToDoList() {
        this.entries = new ArrayList<>();
    }

    /**
     * adds the entries to the list
     * @param entry
     */

    public void addEntry(ToDoEntry entry) {
        entries.add(entry);
    }

    /**
     * gets the entries
     * @return
     */

    public List<ToDoEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * sets the entries
     * @param entries
     */

    public void setEntries(List<ToDoEntry> entries) {
        this.entries = entries;
    }
}
