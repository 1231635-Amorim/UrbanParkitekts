/**
 * The Job class represents a job position in the system.
 * It contains information about the name of the job.
 * Jobs are associated with collaborators in the system.
 *
 * @author [Alexandre]
 */

package pt.ipp.isep.dei.esoft.project.domain;

public class Job {

    private String jobName;

    /**
     * Constructs a Job object with the specified name.
     *
     * @param jobName The name of the job.
     */
    public Job(String jobName){
        this.jobName=jobName;
    }

    /**
     * Gets the name of the job.
     *
     * @return The name of the job.
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * Sets the name of the job.
     *
     * @param jobName The name of the job.
     */
    public void setJobName(String jobName){
        this.jobName=jobName;
    }

    /**
     * Checks if the job is valid.
     *
     * @return True if the job is valid, false otherwise.
     */
    public boolean isValid() {
        if (jobName == null || jobName.isEmpty()) {
            System.out.println("Job name cannot be null or empty");
            return false;
        }

        if (!jobName.matches("[a-zA-Z]+")) {
            System.out.println("Job name cannot include special characters");
            return false;
        }
        return true;
    }

    /**
     * Gets the name of the job.
     *
     * @return The name of the job.
     */
    public String getName() {
        return jobName;
    }
}
