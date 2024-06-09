package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.ToDoList;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoListRepository {

    private static List<ToDoList> toDoLists = new ArrayList<>();

    public ToDoListRepository() {

    }

    public Optional<ToDoList> add(ToDoList toDoList) {
        Optional<ToDoList> newToDoList = Optional.of(toDoList.clone());
        toDoLists.add(newToDoList.get());
        return newToDoList;
    }

    public static List<ToDoList> getAllToDoLists() {
        return List.copyOf(toDoLists);
    }

    /**
     * Updates an existing to-do list entry in the repository.
     *
     * @param updatedEntry The updated to-do list entry.
     */
    public static void updateToDoListEntry(ToDoList updatedEntry) {
        for (int i = 0; i < toDoLists.size(); i++) {
            if (toDoLists.get(i).getTaskDescription().equals(updatedEntry.getTaskDescription())) {
                toDoLists.set(i, updatedEntry);
                break;
            }
        }
    }

    public static List<ToDoList> getAll() {
        return new ArrayList<>(toDoLists);
    }

    public Optional<ToDoList> findByTaskDescription(String taskDescription) {
        for (ToDoList toDoList : toDoLists) {
            for (ToDoEntry entry : toDoList.getEntries()) {
                if (entry.getTask().equals(taskDescription)) {
                    return Optional.of(toDoList);
                }
            }
        }
        return Optional.empty();
    }

    public List<ToDoList> findByUserEmailAndGreenSpaceName(String userEmail, String greenSpaceName) {
        List<ToDoList> filteredToDoLists = new ArrayList<>();
        for (ToDoList toDoList : toDoLists) {
            for (ToDoEntry entry : toDoList.getEntries()) {
                if (entry.getUserEmail().equals(userEmail) && entry.getGreenSpaceName().equals(greenSpaceName)) {
                    filteredToDoLists.add(toDoList);
                }
            }
        }
        return filteredToDoLists;
    }
}
