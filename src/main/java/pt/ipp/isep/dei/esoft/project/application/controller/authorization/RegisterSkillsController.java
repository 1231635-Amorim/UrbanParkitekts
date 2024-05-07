package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

public class RegisterSkillsController {

    private final SkillsRepository skillRepository;

    public RegisterSkillsController() {
        this.skillRepository = new SkillsRepository();
    }

    public boolean registerSkill(String name, String description) {
        // Verifica se a habilidade já existe no repositório
        Skill existingSkill = skillRepository.getSkillByName(name);
        if (existingSkill != null) {
            System.out.println("Skill with the same name already exists!");
            return false;
        }

        // Cria uma nova habilidade e a adiciona ao repositório
        Skill newSkill = new Skill(name, description);
        skillRepository.add(newSkill);
        return true;
    }
}

