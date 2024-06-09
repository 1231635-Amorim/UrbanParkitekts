package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;
import pt.ipp.isep.dei.esoft.project.domain.ToDoList;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;

public class ToDoController {
    private ToDoList toDoList;

    public ToDoController() {
        this.toDoList = new ToDoList();
    }

    public void addToDoEntry(String urgency, GreenSpace greenSpace, Long duration) {
        ToDoEntry entry = new ToDoEntry(urgency, greenSpace, duration);
        toDoList.addEntry(entry);
    }

    public List<ToDoEntry> getToDoEntries() {
        return toDoList.getEntries();
    }

    public List<GreenSpace> getGreenSpacesByUserEmail(String userEmail) {
        GreenSpaceRepository repository = new GreenSpaceRepository();
        return repository.findByUserEmail(userEmail);
    }
}
