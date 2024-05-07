package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.GenerateTeamProposalController;

import java.util.Scanner;

public class GenerateTeamProposalUI implements Runnable {

    private final GenerateTeamProposalController controller;

    public GenerateTeamProposalUI() {
        this.controller = new GenerateTeamProposalController();
    }

    public void run() {
        System.out.println("\n\n--- Generate Team Proposal ----------------");

        // Solicita ao usuário os detalhes necessários para gerar a proposta de equipe
        int minTeamSize = requestMinTeamSize();
        int maxTeamSize = requestMaxTeamSize();
        String[] skills = requestSkills();

        // Chama o controlador para gerar a proposta de equipe
        String teamProposal = controller.generateTeamProposal(minTeamSize, maxTeamSize, skills);

        // Exibe a proposta de equipe gerada
        System.out.println("\nGenerated Team Proposal:");
        System.out.println(teamProposal);
    }

    private int requestMinTeamSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minimum team size: ");
        return input.nextInt();
    }

    private int requestMaxTeamSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter maximum team size: ");
        return input.nextInt();
    }

    private String[] requestSkills() {
        Scanner input = new Scanner(System.in);

        // Solicita ao usuário a lista de habilidades separadas por ponto e vírgula
        System.out.print("Enter skills separated by semicolon (;): ");
        String skillsInput = input.nextLine();

        // Divide a entrada do usuário em um array de habilidades
        String[] skills = skillsInput.split(";");

        // Remove espaços em branco antes e depois de cada habilidade
        for (int i = 0; i < skills.length; i++) {
            skills[i] = skills[i].trim();
        }

        return skills;
    }
}

