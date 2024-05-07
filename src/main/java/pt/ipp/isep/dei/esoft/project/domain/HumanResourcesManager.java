package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HumanResourcesManager {

    /**
     * o nome do gestor de recursos humanos
     */
    private String name;
    /**
     * o email do gestor de recursos humanos
     */
    private  String email;
    /**
     * o número de telefone do gestor de recursos humanos
     */
    private int phoneNumber;

    /**
     * o construtor do gestor de recursos humanos
     * @param email o email do gestor de recursos humanos
     * @param name o nome do gestor de recursos humanos
     * @param phoneNumber o numero de telefone do gestor de recursos humanos
     */
    public HumanResourcesManager(String email, String name, int phoneNumber ){
        this.email=email;
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    /**
     * método para obter o nome
     * @return o nome
     */
    public String getName(){
        return name;
    }

    /**
     * método para obter o email
     * @return o email
     */
    public String getEmail(){
        return email;
    }

    /**
     * método para obter o número de telefone
     * @return o número de telefone
     */
    public int getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * método para alterar o email recebido como parametro
     * @param email recebido como parametro
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * método para alterar o nome recebido como parametro
     * @param name o nome recebido
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * método para alterar o numero de telefone recebido como parametro
     * @param phoneNumber o numero recebido
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * método para registar uma skill
     * @param skill a skill recebida como parametro
     * @param organization a organização recebida como parametro
     * @return
     */
    public boolean registerSkill(Skill skill, Organization organization) {
        if (skill.isValid()) {
            if (organization.isValid()) {
                organization.addSkill(skill);
                return true;
            }
        }
        return false;
    }

    /**
     * método para registar um trabalho
     * @param job o trabalho
     * @param organization a organização
     * @return
     */
    public boolean registerJob (Job job, Organization organization) {
        if (job.isValid()) {
            if (organization.isValid()) {
                organization.addJob(job);
                return true;
            }
        }
        return false;
    }

    /**
     * método para gerar uma proposta de equipa
     * @param minTeamSize o tamanho mínimo permitido
     * @param maxTeamSize o tamanho máximo permitido
     * @param skills as skills dos colaboradores
     * @return a proposta de equipa
     */

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
