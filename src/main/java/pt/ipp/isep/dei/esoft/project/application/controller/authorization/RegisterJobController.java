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
        if (!isValidJobName(name)) {
            System.out.println("Job name can't have special characters or digits!");
            return false;
        }

        Job existingJob = jobRepository.getJobByName(name);
        if (existingJob != null) {
            System.out.println("Job with the same name already exists!");
            return false;
        }

        Job newJob = new Job(name);
        jobRepository.add(newJob);
        return true;
    }

    private boolean isValidJobName(String name) {
        return Pattern.matches("^[a-zA-Z\\s]+$", name);
    }
}

