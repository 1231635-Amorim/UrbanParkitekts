package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LargeSizedParkTest {

    private LargeSizedPark park;

    @Before
    public void setup() {
        park = new LargeSizedPark("Central Park", 500.0, "user@example.com");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Central Park", park.getName());
        assertEquals(500.0, park.getArea(), 0.001);
        assertEquals(GreenSpaceType.LARGE_SIZED_PARK, park.getType());
        assertEquals("user@example.com", park.getEmail());
    }

    @Test
    public void testDisplayDetails() {
        String expectedOutput = "Large-Sized Park: Central Park, Area: 500.0 sqm";
        String actualOutput = park.displayDetails();
        assertEquals(expectedOutput, actualOutput);
    }
}
