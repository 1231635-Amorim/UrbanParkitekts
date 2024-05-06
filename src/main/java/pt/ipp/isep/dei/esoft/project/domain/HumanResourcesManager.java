package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<String> generateTeamProposal(int minTeamSize, int maxTeamSize, String[] skills) {
        List<String> teamProposal = new ArrayList<>();
        Random random = new Random();

        // Verificar se o tamanho mínimo da equipe é válido
        if (minTeamSize <= 0 || minTeamSize > maxTeamSize || minTeamSize > skills.length) {
            throw new IllegalArgumentException("Parâmetros inválidos para geração da proposta de equipe.");
        }

        // Gerar o tamanho da equipe aleatoriamente entre minTeamSize e maxTeamSize
        int teamSize = random.nextInt(maxTeamSize - minTeamSize + 1) + minTeamSize;

        // Adicionar habilidades aleatórias à proposta de equipe
        for (int i = 0; i < teamSize; i++) {
            int randomSkillIndex = random.nextInt(skills.length);
            teamProposal.add(skills[randomSkillIndex]);
        }

        return teamProposal;
    }
}
