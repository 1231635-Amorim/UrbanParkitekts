package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Garden;
import pt.ipp.isep.dei.esoft.project.domain.MediumSizedPark;
import pt.ipp.isep.dei.esoft.project.domain.LargeSizedPark;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpaceType;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;

/**
 * Controller for registering green spaces.
 */
public class RegisterGreenSpaceController {

    private GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructor for RegisterGreenSpaceController.
     * Initializes the GreenSpaceRepository.
     */
    public RegisterGreenSpaceController() {
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

    /**
     * Registers a new green space based on the given parameters.
     *
     * @param name  the name of the green space
     * @param area  the area of the green space in square meters
     * @param type  the type of the green space (GARDEN, MEDIUM_SIZED_PARK, LARGE_SIZED_PARK)
     * @param email the email of the person responsible for the green space
     * @return the registered GreenSpace object
     * @throws IllegalArgumentException if the provided GreenSpaceType is invalid
     */
    public GreenSpace registerGreenSpace(String name, double area, GreenSpaceType type, String email) {
        GreenSpace greenSpace;

        switch (type) {
            case GARDEN:
                greenSpace = new Garden(name, area, email);
                break;
            case MEDIUM_SIZED_PARK:
                greenSpace = new MediumSizedPark(name, area, email);
                break;
            case LARGE_SIZED_PARK:
                greenSpace = new LargeSizedPark(name, area, email);
                break;
            default:
                throw new IllegalArgumentException("Invalid Green Space Type");
        }

        greenSpaceRepository.addGreenSpace(greenSpace);
        return greenSpace;
    }

    /**
     * Retrieves a list of all registered green spaces.
     *
     * @return a list of GreenSpace objects
     */
    public List<GreenSpace> getAllGreenSpaces() {
        return greenSpaceRepository.getGreenSpaces();
    }
}
