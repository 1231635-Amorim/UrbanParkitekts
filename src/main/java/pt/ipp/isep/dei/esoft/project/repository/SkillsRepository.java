package pt.ipp.isep.dei.esoft.project.repository;


    import pt.ipp.isep.dei.esoft.project.domain.Skill;

    import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    public class SkillsRepository {

        private final List<Skill> skills;

        public SkillsRepository() {
            skills = new ArrayList<>();
        }

        /**
         * Retorna uma habilidade existente pelo seu nome.
         *
         * @param skillName O nome da habilidade.
         * @return A habilidade.
         * @throws IllegalArgumentException Se a habilidade não existir, o que nunca deveria acontecer.
         */
        public Skill getSkillByName(String skillName) {

            Skill newSkill = new Skill( skillName);
            Skill skill = null;
            if (skills.contains(newSkill)) {
                skill = skills.get(skills.indexOf(newSkill));
            }
            if (skill == null) {
                throw new IllegalArgumentException(
                        "A habilidade solicitada para [" + skillName + "] não existe.");
            }
            return skill;
        }

        /**
         * Adiciona uma nova habilidade ao repositório.
         *
         * @param skill A habilidade a ser adicionada.
         * @return Um Optional contendo a nova habilidade adicionada, ou vazio se a operação falhar.
         */
        public Optional<Skill> add(Skill skill) {
            Optional<Skill> newSkill = Optional.empty();
            boolean operationSuccess = false;

            if (validateSkill(skill)) {

                operationSuccess = skills.add(newSkill.get());
            }

            if (!operationSuccess) {
                newSkill = Optional.empty();
            }

            return newSkill;
        }

        private boolean validateSkill(Skill skill) {
            return !skills.contains(skill);
        }

        /**
         * Retorna uma cópia defensiva (imutável) da lista de habilidades.
         *
         * @return A lista de habilidades.
         */
        public List<Skill> getSkills() {
            // Esta é uma cópia defensiva, para que o repositório não possa ser modificado externamente.
            return List.copyOf(skills);
        }
    }


