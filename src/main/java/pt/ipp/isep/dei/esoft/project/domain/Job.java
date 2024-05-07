package pt.ipp.isep.dei.esoft.project.domain;

public class Job {

    private String jobName;

    public Job(String jobName){
        this.jobName=jobName;
    }

    public String getJobName(){
        return jobName;
    }

    public void setJobName(String jobName){
        this.jobName=jobName;
    }

    public boolean isValid() {
        if (jobName == null || jobName.isEmpty()) {
            System.out.println("Job name cannot be null or empty");
            return false;
        }

        if (!jobName.matches("[a-zA-Z]+")) {
            System.out.println("Job name cannot include especial characters");
            return false;
        }
        return true;
    }

    public String getName() {
        return null;
    }
}
