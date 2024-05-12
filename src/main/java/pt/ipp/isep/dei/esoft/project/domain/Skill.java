/**
 * The Skill class represents a skill in the system.
 * It contains information about the name of the skill.
 * Skills are associated with collaborators and tasks in the system.
 *
 * @author [Alexandre]
 */

package pt.ipp.isep.dei.esoft.project.domain;

public class Skill {

    private String skillName;

    /**
     * Constructs a Skill object with the specified name.
     *
     * @param name      The name of the skill.
     * @param skillName The name of the skill.
     */
    public Skill(String name, String skillName){
        this.skillName=skillName;
    }

    /**
     * Constructs a Skill object with the specified name.
     *
     * @param skillName The name of the skill.
     */
    public Skill(String skillName) {
        this.skillName = skillName;
    }

    /**
     * Gets the name of the skill.
     *
     * @return The name of the skill.
     */
    public String getSkillName(){
        return skillName;
    }

    /**
     * Sets the name of the skill.
     *
     * @param skillName The name of the skill.
     */
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    /**
     * Checks if the skill is valid.
     *
     * @return True if the skill is valid, false otherwise.
     */
    public boolean isValid() {
        if (skillName == null || skillName.isEmpty()) {
            System.out.println("Skill name cannot be null or empty");
            return false;
        }

        if (!skillName.matches("[a-zA-Z]+")) {
            System.out.println("Skill name cannot include special characters");
            return false;
        }
        return true;
    }
}
