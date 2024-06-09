package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;
import pt.ipp.isep.dei.esoft.project.domain.ToDoList;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;

public class ToDoController {
    private ToDoList toDoList;

    /**
     * Constructor to create a ToDoController.
     *
     * @param
     */

    public ToDoController() {
        this.toDoList = new ToDoList();
    }

    /**
     * this method adds all the parameters to the entry
     *
     * @param urgency
     * @param greenSpace
     * @param duration
     */

    public void addToDoEntry(String urgency, GreenSpace greenSpace, Long duration,String task) {
        ToDoEntry entry = new ToDoEntry(urgency, greenSpace, duration,task);
        toDoList.addEntry(entry);
    }

    /**
     * get all the entries
     *
     * @return
     */

    public List<ToDoEntry> getToDoEntries() {
        return toDoList.getEntries();
    }

    public List<GreenSpace> getGreenSpacesByUserEmail(String userEmail) {
        GreenSpaceRepository repository = new GreenSpaceRepository();
        return repository.findByUserEmail(userEmail);
    }
}
