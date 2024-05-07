package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.util.regex.Pattern;

public class RegisterJobController {

    private final JobRepository jobRepository;

    public RegisterJobController() {
        this.jobRepository = new JobRepository();
    }

    public boolean registerJob(String name) {
        // Verifica se o nome do cargo contém caracteres especiais ou dígitos
        if (!isValidJobName(name)) {
            System.out.println("Job name can't have special characters or digits!");
            return false;
        }

        // Verifica se o cargo já existe no repositório
        Job existingJob = jobRepository.getJobByName(name);
        if (existingJob != null) {
            System.out.println("Job with the same name already exists!");
            return false;
        }

        // Cria um novo cargo e o adiciona ao repositório
        Job newJob = new Job(name);
        jobRepository.add(newJob);
        return true;
    }

    private boolean isValidJobName(String name) {
        // Verifica se o nome contém apenas letras e espaços
        return Pattern.matches("^[a-zA-Z\\s]+$", name);
    }
}

