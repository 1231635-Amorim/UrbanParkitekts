/**
 * The CreateSkillController class is responsible for creating new skills and adding them to the repository.
 * It ensures that a valid name and description are provided for the skill.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.Optional;

public class CreateSkillController {

    private SkillsRepository skillRepository;

    public CreateSkillController() {
        getSkillRepository();
    }

    /**
     * Constructor to create a CreateSkillController with a specified SkillsRepository.
     *
     * @param skillRepository The SkillsRepository to use.
     */
    public CreateSkillController(SkillsRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     * Retrieves the SkillsRepository.
     *
     * @return The SkillsRepository.
     */
    private SkillsRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    /**
     * Creates a new skill with the provided name and description.
     *
     * @param name        The name of the skill.
     * @param description The description of the skill.
     * @return An Optional containing the created Skill, or empty if the skill could not be added.
     */
    public Optional<Skill> createSkill(String name, String description) {
        Skill newSkill = new Skill(name, description);
        return skillRepository.add(newSkill);
    }
}


