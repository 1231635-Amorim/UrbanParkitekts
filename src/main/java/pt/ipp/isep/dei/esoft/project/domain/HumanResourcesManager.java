package pt.ipp.isep.dei.esoft.project.domain;

public class HumanResourcesManager {

    private String name;
    private  String email;
    private int phoneNumber;

    public HumanResourcesManager(String email, String name, int phoneNumber ){
        this.email=email;
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public boolean registerSkill(Skill skill, Organization organization) {
        if (skill.isValid()) {
            if (organization.isValid()) {
                organization.addSkill(skill);
                return true;
            }
        }
        return false;
    }
    public boolean registerJob (Job job, Organization organization) {
        if (job.isValid()) {
            if (organization.isValid()) {
                organization.addJob(job);
                return true;
            }
        }
        return false;
    }
}
