package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.Before;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class GardenTest {

    private ByteArrayOutputStream outContent;
    private static PrintStream originalOut;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterClass
    public static void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testGardenConstructor() {
        Garden garden = new Garden("Rose Garden", 100.0, "user@example.com");
        assertEquals("Rose Garden", garden.getName());
        assertEquals(100.0, garden.getArea(), 0.001);
        assertEquals(GreenSpaceType.GARDEN, garden.getType());
        assertEquals("user@example.com", garden.getEmail());
    }

    @Test
    public void testDisplayDetails() {
        Garden garden = new Garden("Rose Garden", 100.0, "user@example.com");
        garden.displayDetails();
        assertEquals("Garden: Rose Garden, Area: 100.0 sqm\n", outContent.toString());
    }
}