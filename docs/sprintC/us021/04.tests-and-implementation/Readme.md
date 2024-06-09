# US021 - Add a new entry to the To-Do List

## 4.1 Tests

**Test 1:** 

	 @Test
    public void testAddEntry() {
        ToDoEntry toDoEntry = new ToDoEntry("High", greenSpace, 2L, "task1", "user@example.com", "Test Garden");
        toDoList.addEntry(toDoEntry);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(1, entries.size());
        assertEquals(toDoEntry, entries.get(0));
    }



**Test 2:** 

    @Test
    public void testGetEntries() {
        ToDoEntry toDoEntry1 = new ToDoEntry("High", greenSpace, 2L, "task1", "user@example.com", "Test Garden");
        ToDoEntry toDoEntry2 = new ToDoEntry("Medium", greenSpace, 3L, "task2", "user@example.com", "Test Garden");
        toDoList.addEntry(toDoEntry1);
        toDoList.addEntry(toDoEntry2);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(2, entries.size());
        assertEquals(toDoEntry1, entries.get(0));
        assertEquals(toDoEntry2, entries.get(1));
    }


**Test 3:** 

    @Test
    public void testSetEntries() {
        List<ToDoEntry> newEntries = new ArrayList<>();
        ToDoEntry toDoEntry1 = new ToDoEntry("High", greenSpace, 2L, "task1", "user@example.com", "Test Garden");
        ToDoEntry toDoEntry2 = new ToDoEntry("Medium", greenSpace, 3L, "task2", "user@example.com", "Test Garden");
        newEntries.add(toDoEntry1);
        newEntries.add(toDoEntry2);
        toDoList.setEntries(newEntries);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(2, entries.size());
        assertEquals(toDoEntry1, entries.get(0));
        assertEquals(toDoEntry2, entries.get(1));
    }

**Test 4:** 

        @Test
    public void testAddNullEntry() {
        ToDoEntry nullEntry = null;
        toDoList.addEntry(nullEntry);
        assertEquals(0, toDoList.getEntries().size());
    }


**Test 5:** 

    @Test
    public void testSetNullEntries() {
        List<ToDoEntry> nullEntries = null;
        toDoList.setEntries(nullEntries);
        assertEquals(0, toDoList.getEntries().size());
    }



**Test 6:** 

    @Test
    public void testAddEntryMultipleTimes() {
        ToDoEntry toDoEntry = new ToDoEntry("High", greenSpace, 2L, "task1", "user@example.com", "Test Garden");
        toDoList.addEntry(toDoEntry);
        toDoList.addEntry(toDoEntry);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(2, entries.size());
        assertEquals(toDoEntry, entries.get(0));
        assertEquals(toDoEntry, entries.get(1));
    }


**Test 7:**  

    @Test
    public void testGetEntriesIsImmutable() {
        List<ToDoEntry> entries = toDoList.getEntries();
        assertNotSame(entries, toDoList.getEntries());
    }


**Test 8:**  

    @Test
    public void testSetEntriesWithNull() {
        List<ToDoEntry> entries = new ArrayList<>();
        entries.add(new ToDoEntry("High", greenSpace, 2L, "task1", "user@example.com", "Test Garden"));
        toDoList.setEntries(entries);
        toDoList.setEntries(null);
        assertNotNull(toDoList.getEntries());
    }

**Test 9:**

    @Test
    public void testAddEntryWithNull() {
        toDoList.addEntry(null);
        assertEquals(0, toDoList.getEntries().size());
    }

## 4.2 Repository tests


**Test 1:** 

    @Test
    public void testAddToDoList() {
        Optional<ToDoList> addedToDoList = repository.add(toDoList1);
        assertTrue(addedToDoList.isPresent());
        assertEquals(toDoList1, addedToDoList.get());
    }

**Test 2:** 

    @Test
    public void testGetAllToDoLists() {
        repository.add(toDoList1);
        repository.add(toDoList2);
        List<ToDoList> allToDoLists = ToDoListRepository.getAllToDoLists();
        assertEquals(2, allToDoLists.size());
        assertTrue(allToDoLists.contains(toDoList1));
        assertTrue(allToDoLists.contains(toDoList2));
    }


**Test 3:** 

    @Test
    public void testUpdateToDoListEntry() {
        repository.add(toDoList1);
        ToDoList updatedToDoList = new ToDoList("Water plants", "Low", 45, "Central Park", "Completed", "user1@example.com");
        ToDoListRepository.updateToDoListEntry(updatedToDoList);
        Optional<ToDoList> foundToDoList = repository.findByTaskDescription("Water plants");
        assertTrue(foundToDoList.isPresent());
        assertEquals("Low", foundToDoList.get().getUrgency());
        assertEquals(45, foundToDoList.get().getExpectedDuration());
        assertEquals("Completed", foundToDoList.get().getStatus());
    }


**Test 4:** 

    @Test
    public void testFindByTaskDescription() {
        repository.add(toDoList1);
        repository.add(toDoList2);
        Optional<ToDoList> foundToDoList = repository.findByTaskDescription("Prune trees");
        assertTrue(foundToDoList.isPresent());
        assertEquals(toDoList2, foundToDoList.get());
    }

**Test 5:** 

    @Test
    public void testFindByTaskDescriptionNotFound() {
        repository.add(toDoList1);
        repository.add(toDoList2);
        Optional<ToDoList> foundToDoList = repository.findByTaskDescription("Non-existing task");
        assertFalse(foundToDoList.isPresent());
    }

**Test 6:** 

    @Test
    public void testFindByUserEmailAndGreenSpaceName() {
        repository.add(toDoList1);
        repository.add(toDoList2);
        repository.add(toDoList3);
        List<ToDoList> foundToDoLists = repository.findByUserEmailAndGreenSpaceName("user1@example.com", "Central Park");
        assertEquals(1, foundToDoLists.size());
        assertTrue(foundToDoLists.contains(toDoList1));
    }

**Test 7:** 

    @Test
    public void testFindByUserEmailAndGreenSpaceNameNotFound() {
        repository.add(toDoList1);
        repository.add(toDoList2);
        List<ToDoList> foundToDoLists = repository.findByUserEmailAndGreenSpaceName("non-existing-user@example.com", "Central Park");
        assertTrue(foundToDoLists.isEmpty());
    }

**Test 8:** 

    @Test
    public void testFindByUserEmailAndGreenSpaceNameNoMatch() {
        repository.add(toDoList1);
        repository.add(toDoList2);
        List<ToDoList> foundToDoLists = repository.findByUserEmailAndGreenSpaceName("user1@example.com", "Non-existing park");
        assertTrue(foundToDoLists.isEmpty());
    }

**Test 9:**

    @Test
        public void testToString() {
        repository.add(toDoList1);
        assertEquals("Task Description: Water plants, Urgency: High, Expected Duration: 30 minutes, Greenspace: Central Park, Status: Pending", toDoList1.toString());
    }


## 5. Construction (Implementation)

### Class ToDoController

```java
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

    public void addToDoEntry(String urgency, GreenSpace greenSpace, Long duration, String task, String userEmail, String greenSpaceName) {
        ToDoEntry entry = new ToDoEntry(urgency, greenSpace, duration, task, userEmail, greenSpaceName);
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


```

### Class ToDoList

```java
package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

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
}


```

### Class ToDoListRepository

```java
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

```


## 6. Integration and Demo

* A new option on the GSM menu options was added.


## 7. Observations

n/a