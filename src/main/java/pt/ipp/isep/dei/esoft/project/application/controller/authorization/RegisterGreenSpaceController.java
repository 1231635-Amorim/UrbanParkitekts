package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Garden;
import pt.ipp.isep.dei.esoft.project.domain.MediumSizedPark;
import pt.ipp.isep.dei.esoft.project.domain.LargeSizedPark;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpaceType;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;

public class RegisterGreenSpaceController {

    private GreenSpaceRepository greenSpaceRepository;

    public RegisterGreenSpaceController() {
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

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

    public List<GreenSpace> getAllGreenSpaces() {
        return greenSpaceRepository.getGreenSpaces();
    }
}
