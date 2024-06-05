# US020 - Register a GreenSpace

## 4. Tests

### GreenSpaceRepositoryTest

**Test 1:** Clear the list of GreenSpace objects in the repository before each test.


    @Before
    public void setUp() {
        greenSpaceRepository = new GreenSpaceRepository();
        }


**Test 2:** Clear the list of GreenSpace objects in the repository after each test.


    @After
    public void tearDown() {
        greenSpaceRepository.clear();
    }


**Test 3:** Add a GreenSpace object to the repository and retrieve it.

    @Test
    public void testAddAndGetGreenSpaces() {
        GreenSpace greenSpace = new Garden("Central Park", 500.0, "user@example.com");
        greenSpaceRepository.addGreenSpace(greenSpace);
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        assertEquals(1, greenSpaces.size());
        assertEquals(greenSpace, greenSpaces.get(0));
        }

**Test 4:** Retrieve GreenSpace objects when the repository is empty.

    @Test
    public void testGetGreenSpaces_EmptyList() {
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        assertTrue(greenSpaces.isEmpty());
    }

**Test 5:** Add a null GreenSpace object to the repository.

    @Test
    public void testAddGreenSpace_Null() {
        GreenSpace greenSpace = null;
        assertThrows(IllegalArgumentException.class, () -> {
            greenSpaceRepository.addGreenSpace(greenSpace);
        });
    }


**Test 6:** Add a duplicate GreenSpace object to the repository.

    @Test
    public void testAddGreenSpace_Duplicate() {
        GreenSpace greenSpace1 = new Garden("Central Park", 500.0, "user1@example.com");
        greenSpaceRepository.addGreenSpace(greenSpace1);
        GreenSpace greenSpace2 = new Garden("Central Park", 500.0, "user1@example.com");
        assertThrows(IllegalArgumentException.class, () -> {
            greenSpaceRepository.addGreenSpace(greenSpace2);
        });
    }


**Test 7:** Add an invalid GreenSpace object to the repository.

    @Test
    public void testAddGreenSpace_InvalidGreenSpace() {
        GreenSpace greenSpace = new Garden("", -500.0, "invalid-email");
        assertThrows(IllegalArgumentException.class, () -> {
            greenSpaceRepository.addGreenSpace(greenSpace);
        });
    }


### GreenSpaceTest

**Test 1:** Get the name of the GreenSpace.

    @Test
    public void testGetName() {
    GreenSpace greenSpace = new TestGreenSpace("Test", 100.0, GreenSpaceType.GARDEN, "test@example.com");

        String name = greenSpace.getName();
        assertEquals("Test", name);
    }

**Test 2:** Get the area of the GreenSpace.

    @Test
    public void testGetArea() {
        GreenSpace greenSpace = new TestGreenSpace("Test", 100.0, GreenSpaceType.GARDEN, "test@example.com");

        double area = greenSpace.getArea();
        assertEquals(100.0, area, 0.001);
    }


**Test 3:** Get the type of the GreenSpace.

    @Test
    public void testGetType() {
        GreenSpace greenSpace = new TestGreenSpace("Test", 100.0, GreenSpaceType.GARDEN, "test@example.com");

        GreenSpaceType type = greenSpace.getType();

        assertEquals(GreenSpaceType.GARDEN, type);
    }


**Test 4:** Get the email of the GreenSpace.

    @Test
    public void testGetEmail() {
        GreenSpace greenSpace = new TestGreenSpace("Test", 100.0, GreenSpaceType.GARDEN, "test@example.com");

        String email = greenSpace.getEmail();

        assertEquals("test@example.com", email);
    }


**Test 5:** Create a GreenSpace with a negative area.

    @Test
    public void testNegativeArea() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestGreenSpace("Test", -100.0, GreenSpaceType.GARDEN, "test@example.com");
        });
    }


**Test 6:** Create a GreenSpace with zero area.

    @Test
    public void testZeroArea() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestGreenSpace("Test", 0.0, GreenSpaceType.GARDEN, "test@example.com");
        });
    }


**Test 7:** Create a GreenSpace with an empty name.

    @Test
    public void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestGreenSpace("", 100.0, GreenSpaceType.GARDEN, "test@example.com");
        });
    }


**Test 8:** Create a GreenSpace with a null name.

    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestGreenSpace(null, 100.0, GreenSpaceType.GARDEN, "test@example.com");
        });
    }


**Test 9:** Create a GreenSpace with an invalid email.

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestGreenSpace("Test", 100.0, GreenSpaceType.GARDEN, "invalid-email");
        });
    }


**Test 10:** Create a GreenSpace with a null email.

    @Test
    public void testNullEmail() {
    assertThrows(IllegalArgumentException.class, () -> {
    new TestGreenSpace("Test", 100.0, GreenSpaceType.GARDEN, null);
    });
    }

**Test 11:** Create a GreenSpace with a null type.

    @Test
    public void testNullType() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestGreenSpace("Test", 100.0, null, "test@example.com");
        });
    }

## 5. Construction (Implementation)

### Class RegisterGreenSpaceUI

```java
package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpaceType;

import java.util.List;
import java.util.Scanner;

/**
 * This class provides a user interface for registering green spaces.
 */
public class RegisterGreenSpaceUI implements Runnable {

    /**
     * The scanner used to read input from the user.
     */
    private final Scanner scanner;

    /**
     * The email address of the user who is logged in.
     */
    private final String userEmail;

    /**
     * Constructs a new RegisterGreenSpaceUI object with the specified user email.
     *
     * @param userEmail the email address of the user who is logged in
     */
    public RegisterGreenSpaceUI(String userEmail) {
        this.userEmail = userEmail;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the user interface for registering green spaces.
     */
    public void run() {
        System.out.println("\n--- Green Space Management ---");
        System.out.println("Logged in as: " + userEmail);
        System.out.print("Enter name of the green space: ");
        String name = scanner.nextLine();

        System.out.print("Enter area of the green space in square meters: ");
        double area = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Select type of green space:");
        System.out.println("1. Garden");
        System.out.println("2. Medium-Sized Park");
        System.out.println("3. Large-Sized Park");
        int typeChoice = scanner.nextInt();

        GreenSpaceType type;

        switch (typeChoice) {
            case 1:
                type = GreenSpaceType.GARDEN;
                break;
            case 2:
                type = GreenSpaceType.MEDIUM_SIZED_PARK;
                break;
            case 3:
                type = GreenSpaceType.LARGE_SIZED_PARK;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        RegisterGreenSpaceController.registerGreenSpace(name, area, type, userEmail);
        System.out.println("Green space registered successfully.");

        System.out.println("\n--- Registered Green Spaces ---");
        List<GreenSpace> greenSpaces = RegisterGreenSpaceController.getAllGreenSpaces();
        for (GreenSpace greenSpace : greenSpaces) {
            greenSpace.displayDetails();
        }
    }
}
```

### Class GreenSpaceRepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a repository for managing GreenSpace objects.
 */
public class GreenSpaceRepository {
    public void clear() {
        greenSpaces.clear();
    }

    /**
     * The list of GreenSpace objects stored in the repository.
     */
    private static List<GreenSpace> greenSpaces = new ArrayList<>();

    /**
     * Adds a GreenSpace object to the repository.
     *
     * @param greenSpace the GreenSpace object to be added
     */
    public static void addGreenSpace(GreenSpace greenSpace) {
        if (greenSpace == null) {
            throw new NullPointerException("GreenSpace cannot be null");
        }
        if (greenSpaces.contains(greenSpace)) {
            throw new IllegalStateException("Duplicate GreenSpace cannot be added");
        }
        greenSpaces.add(greenSpace);
    }

    /**
     * Checks if a GreenSpace object exists in the repository.
     *
     * @param greenSpace the GreenSpace object to check for
     * @return true if the GreenSpace object exists in the repository, false otherwise
     */
    private static boolean containsGreenSpace(GreenSpace greenSpace) {
        return greenSpaces.stream()
                .anyMatch(gs -> gs.getName().equals(greenSpace.getName()) && gs.getEmail().equals(greenSpace.getEmail()));
    }

    /**
     * Retrieves all GreenSpace objects stored in the repository.
     *
     * @return a list of all GreenSpace objects stored in the repository
     */
    public static List<GreenSpace> getGreenSpaces() {
        return new ArrayList<>(greenSpaces);
    }

    /**
     * Retrieves a list of GreenSpace objects associated with a specific user email.
     *
     * @param userEmail the email address of the user to retrieve GreenSpaces for
     * @return a list of GreenSpace objects associated with the specified user email
     */
    public List<GreenSpace> findByUserEmail(String userEmail) {
        List<GreenSpace> userGreenSpaces = new ArrayList<>();
        for (GreenSpace greenSpace : greenSpaces) {
            if (greenSpace.getEmail().equals(userEmail)) {
                userGreenSpaces.add(greenSpace);
            }
        }
        return userGreenSpaces;
    }
}
```

### Class RegisterGreenSpaceController

```java
package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Garden;
import pt.ipp.isep.dei.esoft.project.domain.MediumSizedPark;
import pt.ipp.isep.dei.esoft.project.domain.LargeSizedPark;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpaceType;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;


/**
 * Controller class responsible for registering green spaces and retrieving all registered green spaces.
 */
public class RegisterGreenSpaceController {

    /**
     * Default constructor.
     */
    public RegisterGreenSpaceController() {
    }

    /**
     * Registers a new green space based on the provided parameters.
     *
     * @param name the name of the green space
     * @param area the area of the green space
     * @param type the type of the green space (GARDEN, MEDIUM_SIZED_PARK, LARGE_SIZED_PARK)
     * @param email the email of the user who registered the green space
     * @return the registered green space object
     */
    public static GreenSpace registerGreenSpace(String name, double area, GreenSpaceType type, String email) {
        switch (type) {
            case GARDEN:
                return new Garden(name, area, email);
            case MEDIUM_SIZED_PARK:
                return new MediumSizedPark(name, area, email);
            case LARGE_SIZED_PARK:
                return new LargeSizedPark(name, area, email);
            default:
                throw new IllegalArgumentException("Invalid Green Space Type");
        }
    }

    /**
     * Retrieves a list of all registered green spaces.
     *
     * @return a list of all registered green spaces
     */
    public static List<GreenSpace> getAllGreenSpaces() {
        return GreenSpaceRepository.getGreenSpaces();
    }
}


```

### Class GreenSpace
```java
package pt.ipp.isep.dei.esoft.project.domain;

/**
 * This abstract class represents a green space.
 */
public abstract class GreenSpace {
    /**
     * The name of the green space.
     */
    private String name;

    /**
     * The area of the green space.
     */
    private double area;

    /**
     * The type of the green space.
     */
    private GreenSpaceType type;

    /**
     * The email address of the green space.
     */
    private String email;

    /**
     * Constructs a new GreenSpace with the given name, area, type, and email.
     *
     * @param name the name of the green space
     * @param area the area of the green space
     * @param type the type of the green space
     * @param email the email address of the green space
     */
    public GreenSpace(String name, double area, GreenSpaceType type, String email) {
        this.name = validateName(name);
        this.area = validateArea(area);
        this.type = validateType(type);
        this.email = validateEmail(email);
    }

    /**
     * Validates the name of the green space.
     *
     * @param name the name to be validated
     * @return the validated name
     */
    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name;
    }

    /**
     * Validates the area of the green space.
     *
     * @param area the area to be validated
     * @return the validated area
     */
    private double validateArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be positive");
        }
        return area;
    }

    /**
     * Validates the type of the green space.
     *
     * @param type the type to be validated
     * @return the validated type
     */
    private GreenSpaceType validateType(GreenSpaceType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        return type;
    }

    /**
     * Validates the email address of the green space.
     *
     * @param email the email address to be validated
     * @return the validated email address
     */
    private String validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        return email;
    }


    /**
     * Returns the name of the green space.
     *
     * @return the name of the green space
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the area of the green space.
     *
     * @return the area of the green space
     */
    public double getArea() {
        return area;
    }


    /**
     * Returns the type of the green space.
     *
     * @return the type of the green space
     */
    public GreenSpaceType getType() {
        return type;
    }


    /**
     * Returns the email address of the green space.
     *
     * @return the email address of the green space
     */
    public String getEmail() {
        return email;
    }


    /**
     * This method must be implemented by subclasses to display details about a green space.
     *
     * @return
     */
    public abstract String displayDetails();
}
```

## 6. Integration and Demo

* Introduced a new feature in the Employee menu to facilitate the registration of green spaces.
* Automatically populated some green spaces upon system initialization for demonstration purposes.

## 7. Observations