package pt.ipp.isep.dei.esoft.project.domain;

public class Garden extends GreenSpace {

    /**
     * Constructs a new Garden with the given name, area, and email.
     *
     * @param name  the name of the garden
     * @param areaInHectares  the area of the garden
     * @param email the email of the garden
     */
    public Garden(String name, double areaInHectares, String email) {
        super(name, areaInHectares, GreenSpaceType.GARDEN, email);
    }

    /**
     * Displays the details of the garden.
     *
     * @return the formatted details string
     */
    @Override
    public String displayDetails() {
        return String.format("%s: %s, Area: %.1f hectares", getType(), getName(), getAreaInHectares());
    }
}
