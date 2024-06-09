package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoList {
    private String taskDescription;
    private String urgency;
    private int expectedDuration;
    private String greenspace;
    private String status;
    private String userEmail;
    private List<ToDoEntry> entries; // Add field to store entries

    /**
     * Constructs a new ToDoList object with parameters.
     */
    public ToDoList(String taskDescription, String urgency, int expectedDuration, String greenspace, String status, String userEmail) {
        this.taskDescription = taskDescription;
        this.urgency = urgency;
        this.expectedDuration = expectedDuration;
        this.greenspace = greenspace;
        this.status = status;
        this.userEmail = userEmail;
        this.entries = new ArrayList<>(); // Initialize the list
    }

    /**
     * Constructs a new ToDoList object.
     */
    public ToDoList() {
        this.entries = new ArrayList<>();
    }

    /**
     * Adds an entry to the to-do list.
     * @param entry The entry to add.
     */
    public void addEntry(ToDoEntry entry) {
        entries.add(entry);
    }

    /**
     * Gets all entries in the to-do list.
     * @return The list of entries.
     */
    public List<ToDoEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * Sets the entries in the to-do list.
     * @param entries The entries to set.
     */
    public void setEntries(List<ToDoEntry> entries) {
        this.entries = entries;
    }

    @Override
    public ToDoList clone() {
        ToDoList clonedList = new ToDoList();
        for (ToDoEntry entry : this.entries) {
            clonedList.addEntry(entry);
        }
        return clonedList;
    }

    // Getters and setters for other fields...

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public String getGreenspace() {
        return greenspace;
    }

    public void setGreenspace(String greenspace) {
        this.greenspace = greenspace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean contains(ToDoEntry entry) {
        return entries.contains(entry);
    }


    public List<ToDoEntry> getPendingEntriesByUserEmail(String userEmail) {
        return entries.stream()
                .filter(entry -> entry.getUserEmail().equals(userEmail) && entry.isPending())
                .collect(Collectors.toList());
    }
}
