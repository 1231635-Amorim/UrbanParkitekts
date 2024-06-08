/**
 * The RegisterJobController class is responsible for registering new job positions
 * and validating their names.
 * It interacts with JobRepository to persist the new jobs.
 * This class ensures that the provided job name is valid before registering a new job.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.util.regex.Pattern;
import java.util.List;

public class RegisterJobController {

    private final JobRepository jobRepository;

    /**
     * Constructs a RegisterJobController with a JobRepository instance.
     */
    public RegisterJobController() {
        this.jobRepository = new JobRepository();
    }

    /**
     * Registers a new job with the provided name.
     *
     * @param name The name of the job to register.
     * @return True if the job was successfully registered, false otherwise.
     */
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

    /**
     * Retrieves the list of all registered job positions.
     *
     * @return The list of registered job positions.
     */
    public List<Job> getJobList() {
        return jobRepository.getAllJobs();
    }

    /**
     * Checks if the provided job name is valid.
     *
     * @param name The job name to validate.
     * @return True if the job name is valid, false otherwise.
     */
    private boolean isValidJobName(String name) {
        return Pattern.matches("^[a-zA-Z\\s]+$", name);
    }

}
