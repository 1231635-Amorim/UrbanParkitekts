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