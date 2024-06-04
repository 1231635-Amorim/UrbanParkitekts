package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MediumSizedParkTest {

    private MediumSizedPark park;

    @Before
    public void setup() {
        park = new MediumSizedPark("City Park", 300.0, "user@example.com");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("City Park", park.getName());
        assertEquals(300.0, park.getArea(), 0.001);
        assertEquals(GreenSpaceType.MEDIUM_SIZED_PARK, park.getType());
        assertEquals("user@example.com", park.getEmail());
    }

    @Test
    public void testDisplayDetails() {
        String expectedOutput = "Medium-Sized Park: City Park, Area: 300.0 sqm";
        String actualOutput = park.displayDetails();
        assertEquals(expectedOutput, actualOutput);
    }
}