package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Garden;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GreenSpaceRepositoryTest {

    private GreenSpaceRepository greenSpaceRepository;

    @Before
    public void setUp() {
        greenSpaceRepository = new GreenSpaceRepository();
    }

    @After
    public void tearDown() {
        greenSpaceRepository.clear();
    }

    @Test
    public void testAddAndGetGreenSpaces() {
        GreenSpace greenSpace = new Garden("Central Park", 500.0, "user@example.com");
        greenSpaceRepository.addGreenSpace(greenSpace);
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        assertEquals(1, greenSpaces.size());
        assertEquals(greenSpace, greenSpaces.get(0));
    }

    @Test
    public void testGetGreenSpaces_EmptyList() {
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        assertTrue(greenSpaces.isEmpty());
    }

    @Test
    public void testAddGreenSpace_Null() {
        GreenSpace greenSpace = null;
        assertThrows(NullPointerException.class, () -> {
            greenSpaceRepository.addGreenSpace(greenSpace);
        });
    }


    @Test
    public void testAddGreenSpace_Duplicate() {
        GreenSpace greenSpace1 = new Garden("Central Park", 500.0, "user1@example.com");
        greenSpaceRepository.addGreenSpace(greenSpace1);
        GreenSpace greenSpace2 = new Garden("Central Park", 500.0, "user1@example.com");
        assertThrows(IllegalArgumentException.class, () -> {
            greenSpaceRepository.addGreenSpace(greenSpace2);
        });
    }

    @Test
    public void testAddGreenSpace_InvalidGreenSpace() {
        assertThrows(IllegalArgumentException.class, () -> {
            GreenSpace greenSpace = new Garden("Invalid Garden", -500.0, "invalid-email");
            greenSpaceRepository.addGreenSpace(greenSpace);
        });
    }

}