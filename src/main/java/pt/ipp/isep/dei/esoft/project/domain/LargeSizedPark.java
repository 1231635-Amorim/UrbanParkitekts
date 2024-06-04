package pt.ipp.isep.dei.esoft.project.domain;

/**
 * This class extends the GreenSpace class and represents a large-sized park.
 */
public class LargeSizedPark extends GreenSpace {

    /**
     * Constructs a new LargeSizedPark with the given name, area, and email.
     *
     * @param name the name of the park
     * @param area the area of the park
     * @param email the email address of the park
     */
    public LargeSizedPark(String name, double area, String email) {
        super(name, area, GreenSpaceType.LARGE_SIZED_PARK, email);
    }

    /**
     * This method is overridden from the GreenSpace class to display details about a large-sized park.
     *
     * @return
     */
    @Override
    public String displayDetails() {
        System.out.println("Large-Sized Park: " + getName() + ", Area: " + getArea() + " sqm");
        return null;
    }
}