package pt.ipp.isep.dei.esoft.project.domain;

public class Skill {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return true;
    }

}
