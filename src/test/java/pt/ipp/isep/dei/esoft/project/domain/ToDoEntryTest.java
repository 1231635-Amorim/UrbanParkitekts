package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ToDoEntryTest {

    private ToDoEntry toDoEntry;
    private GreenSpace greenSpace;

    @Before
    public void setUp() {
        greenSpace = new Garden("Test Garden", 100.0, "user@example.com");
        toDoEntry = new ToDoEntry("High", greenSpace, 2L, "Task", "user@example.com", "Test Garden");
    }

    @After
    public void tearDown() {
        // Clean up any resources if needed
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("High", toDoEntry.getUrgency());
        assertEquals(greenSpace, toDoEntry.getAssociatedGreenSpace());
        assertEquals(Long.valueOf(2L), toDoEntry.getDuration());
    }

    @Test
    public void testToString() {
        String expectedOutput = "ToDoEntry{urgency='High', associatedGreenSpace=Test Garden}";
        String actualOutput = toDoEntry.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSetUrgency() {
        toDoEntry.setUrgency("Medium");
        assertEquals("Medium", toDoEntry.getUrgency());
    }

    @Test
    public void testSetAssociatedGreenSpace() {
        GreenSpace newGreenSpace = new Garden("New Garden", 200.0, "user@example.com");
        toDoEntry.setAssociatedGreenSpace(newGreenSpace);
        assertEquals(newGreenSpace, toDoEntry.getAssociatedGreenSpace());
    }

    @Test
    public void testSetDuration() {
        toDoEntry.setDuration(3L);
        assertEquals(Long.valueOf(3L), toDoEntry.getDuration());
    }

    @Test
    public void testSetUrgency_Null() {
        toDoEntry.setUrgency(null);
        assertNull(toDoEntry.getUrgency());
    }

    @Test
    public void testSetAssociatedGreenSpace_Null() {
        toDoEntry.setAssociatedGreenSpace(null);
        assertNull(toDoEntry.getAssociatedGreenSpace());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDuration_Negative() {
        toDoEntry.setDuration(-1L);
    }
}
