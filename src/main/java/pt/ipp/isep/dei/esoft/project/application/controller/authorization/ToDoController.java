package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;
import pt.ipp.isep.dei.esoft.project.domain.ToDoList;
import pt.ipp.isep.dei.esoft.project.repository.*;


import java.util.ArrayList;
import java.util.List;

public class ToDoController {
    private ToDoList toDoList;
    private GreenSpaceRepository greenSpaceRepository;
    public ToDoController() {
        this.toDoList = new ToDoList();
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

    public void addToDoEntry(String urgency, GreenSpace greenSpace, Long duration, String task, String userEmail, String greenSpaceName) {
        ToDoEntry entry = new ToDoEntry(urgency, greenSpace, duration, task, userEmail, greenSpaceName);
        toDoList.addEntry(entry);
    }

    public List<ToDoEntry> getToDoEntries() {
        return toDoList.getEntries();
    }

    public List<String> getAllToDoListEntries() {
        List<String> allEntries = new ArrayList<>();
        for (ToDoEntry entry : toDoList.getEntries()) {
            allEntries.add(entry.toString());
        }
        return allEntries;
    }

    public List<GreenSpace> getGreenSpacesByUserEmail(String userEmail) {
        return greenSpaceRepository.getGreenSpacesByUserEmail(userEmail);
    }
}
