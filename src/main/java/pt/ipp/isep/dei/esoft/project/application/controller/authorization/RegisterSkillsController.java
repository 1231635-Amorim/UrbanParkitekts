/**
 * The RegisterSkillsController class is responsible for registering new skills
 and validating their names.
 * It interacts with SkillsRepository to persist the new skills.
 * This class ensures that the provided skill name is unique before registering a new skill.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

public class RegisterSkillsController {

    private final SkillsRepository skillRepository;

    /**
     * Constructs a RegisterSkillsController with a SkillsRepository instance.
     */
    public RegisterSkillsController() {
        this.skillRepository = new SkillsRepository();
    }

    /**
     * Registers a new skill with the provided name and description.
     *
     * @param name        The name of the skill.
     * @param description The description of the skill.
     * @return True if the skill was successfully registered, false otherwise.
     */
    public boolean registerSkill(String name, String description) {
        Skill existingSkill = skillRepository.getSkillByName(name);
        if (existingSkill != null) {
            System.out.println("Skill with the same name already exists!");
            return false;
        }

        Skill newSkill = new Skill(name, description);
        skillRepository.add(newSkill);
        return true;
    }
}
