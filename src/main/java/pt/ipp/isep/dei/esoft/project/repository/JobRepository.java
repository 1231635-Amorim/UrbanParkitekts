package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobRepository {

    private final List<Job> jobs;

    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    public Optional<Job> add(Job job) {
        // Verifica se o cargo já existe no repositório
        if (jobs.contains(job)) {
            System.out.println("Job with the same name already exists!");
            return Optional.empty();
        }

        // Adiciona o novo cargo ao repositório
        jobs.add(job);
        return Optional.of(job);
    }

    public Job getJobByName(String name) {
        // Procura o cargo pelo nome no repositório
        for (Job job : jobs) {
            if (job.getName().equalsIgnoreCase(name)) {
                return job;
            }
        }
        return null; // Retorna null se o cargo não for encontrado
    }

    public List<Job> getAllJobs() {
        // Retorna uma cópia da lista de cargos
        return new ArrayList<>(jobs);
    }
}

