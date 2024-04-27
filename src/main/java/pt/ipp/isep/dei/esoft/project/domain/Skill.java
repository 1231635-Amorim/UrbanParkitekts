package pt.ipp.isep.dei.esoft.project.domain;

public class Skill {

    private String skillName;

    public Skill(String skillName){
        this.skillName=skillName;
    }

    public String getSkillName(){
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public boolean isValid() {
        if (skillName == null || skillName.isEmpty()) {
            System.out.println("Skill name cannot be null or empty");
            return false;
        }

        if (!skillName.matches("[a-zA-Z]+")) {
            System.out.println("Skill name cannot include especial characters");
            return false;
        }
        return true;
    }
}
