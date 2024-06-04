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
