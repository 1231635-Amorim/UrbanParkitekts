/**
 * The JobRepository class is responsible for managing the storage and retrieval of job data.
 * It provides methods to add, retrieve, and get all jobs from the repository.
 * Jobs are stored in a list.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobRepository {

    private final List<Job> jobs;

    /**
     * Constructs a JobRepository with an empty list of jobs.
     */
    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Adds a job to the repository.
     *
     * @param job The job to add.
     * @return An Optional containing the added job if successful, or empty otherwise.
     */
    public Optional<Job> add(Job job) {
        // Check if the job already exists in the repository
        if (jobs.contains(job)) {
            System.out.println("Job with the same name already exists!");
            return Optional.empty();
        }

        // Add the new job to the repository
        jobs.add(job);
        return Optional.of(job);
    }

    /**
     * Retrieves a job from the repository by name.
     *
     * @param name The name of the job to retrieve.
     * @return The job with the specified name, or null if not found.
     */
    public Job getJobByName(String name) {
        // Search for the job by name in the repository
        for (Job job : jobs) {
            if (job.getName().equalsIgnoreCase(name)) {
                return job;
            }
        }
        return null; // Return null if the job is not found
    }

    /**
     * Gets all jobs from the repository.
     *
     * @return A list containing all jobs in the repository.
     */
    public List<Job> getAllJobs() {
        // Return a copy of the list of jobs
        return new ArrayList<>(jobs);
    }
}
