package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ToDoListTest {

    private ToDoList toDoList;
    private GreenSpace greenSpace;

    @Before
    public void setUp() {
        toDoList = new ToDoList();
        greenSpace = new Garden("Test Garden", 100.0, "user@example.com");
    }

    @After
    public void tearDown() {
        // Clean up any resources if needed
    }

    @Test
    public void testAddEntry() {
        ToDoEntry toDoEntry = new ToDoEntry("High", greenSpace, 2L);
        toDoList.addEntry(toDoEntry);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(1, entries.size());
        assertEquals(toDoEntry, entries.get(0));
    }

    @Test
    public void testGetEntries() {
        ToDoEntry toDoEntry1 = new ToDoEntry("High", greenSpace, 2L);
        ToDoEntry toDoEntry2 = new ToDoEntry("Medium", greenSpace, 3L);
        toDoList.addEntry(toDoEntry1);
        toDoList.addEntry(toDoEntry2);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(2, entries.size());
        assertEquals(toDoEntry1, entries.get(0));
        assertEquals(toDoEntry2, entries.get(1));
    }

    @Test
    public void testSetEntries() {
        List<ToDoEntry> newEntries = new ArrayList<>();
        ToDoEntry toDoEntry1 = new ToDoEntry("High", greenSpace, 2L);
        ToDoEntry toDoEntry2 = new ToDoEntry("Medium", greenSpace, 3L);
        newEntries.add(toDoEntry1);
        newEntries.add(toDoEntry2);
        toDoList.setEntries(newEntries);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(2, entries.size());
        assertEquals(toDoEntry1, entries.get(0));
        assertEquals(toDoEntry2, entries.get(1));
    }

    @Test
    public void testAddNullEntry() {
        ToDoEntry nullEntry = null;
        toDoList.addEntry(nullEntry);
        assertEquals(0, toDoList.getEntries().size());
    }

    @Test
    public void testSetNullEntries() {
        List<ToDoEntry> nullEntries = null;
        toDoList.setEntries(nullEntries);
        assertEquals(0, toDoList.getEntries().size());
    }

    @Test
    public void testAddEntryMultipleTimes() {
        ToDoEntry toDoEntry = new ToDoEntry("High", greenSpace, 2L);
        toDoList.addEntry(toDoEntry);
        toDoList.addEntry(toDoEntry);
        List<ToDoEntry> entries = toDoList.getEntries();
        assertEquals(2, entries.size());
        assertEquals(toDoEntry, entries.get(0));
        assertEquals(toDoEntry, entries.get(1));
    }

    @Test
    public void testGetEntriesIsImmutable() {
        List<ToDoEntry> entries = toDoList.getEntries();
        assertNotSame(entries, toDoList.getEntries());
    }

    @Test
    public void testSetEntriesWithNull() {
        List<ToDoEntry> entries = new ArrayList<>();
        entries.add(new ToDoEntry("High", greenSpace, 2L));
        toDoList.setEntries(entries);
        toDoList.setEntries(null);
        assertNotNull(toDoList.getEntries());
    }

    @Test
    public void testAddEntryWithNull() {
        toDoList.addEntry(null);
        assertEquals(0, toDoList.getEntries().size());
    }
}
