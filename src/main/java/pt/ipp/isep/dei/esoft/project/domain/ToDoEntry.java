package pt.ipp.isep.dei.esoft.project.domain;

/**
 * Represents a ToDoEntry in the system.
 */
public class ToDoEntry {
    private String urgency;
    private GreenSpace associatedGreenSpace;
    private Long duration;
    private String task;
    private String userEmail;
    private String greenSpaceName;

    /**
     * Constructs a new ToDoEntry object with the given parameters.
     *
     * @param urgency             The urgency level of the task.
     * @param associatedGreenSpace The associated GreenSpace object.
     * @param duration            The duration of the task.
     * @param task                The description of the task.
     * @param userEmail           The email of the user associated with the task.
     * @param greenSpaceName      The name of the green space associated with the task.
     */
    public ToDoEntry(String urgency, GreenSpace associatedGreenSpace, Long duration, String task, String userEmail, String greenSpaceName) {
        this.urgency = urgency;
        this.associatedGreenSpace = associatedGreenSpace;
        this.duration = duration;
        this.task = task;
        this.userEmail = userEmail;
        this.greenSpaceName = greenSpaceName;
    }

    // Getters and Setters

    /**
     * Retrieves the urgency level of the task.
     *
     * @return The urgency level.
     */
    public String getUrgency() {
        return urgency;
    }

    /**
     * Retrieves the description of the task.
     *
     * @return The task description.
     */
    public String getTask() {
        return task;
    }

    /**
     * Retrieves the associated GreenSpace object.
     *
     * @return The associated GreenSpace.
     */
    public GreenSpace getAssociatedGreenSpace() {
        return associatedGreenSpace;
    }

    /**
     * Retrieves the duration of the task.
     *
     * @return The task duration.
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * Sets the urgency level of the task.
     *
     * @param urgency The urgency level to set.
     */
    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    /**
     * Sets the duration of the task.
     *
     * @param duration The duration to set.
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    /**
     * Sets the description of the task.
     *
     * @param task The task description to set.
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Retrieves the email of the user associated with the task.
     *
     * @return The user's email.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Retrieves the name of the green space associated with the task.
     *
     * @return The green space name.
     */
    public String getGreenSpaceName() {
        return greenSpaceName;
    }

    /**
     * Sets the email of the user associated with the task.
     *
     * @param userEmail The user's email to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Sets the name of the green space associated with the task.
     *
     * @param greenSpaceName The green space name to set.
     */
    public void setGreenSpaceName(String greenSpaceName) {
        this.greenSpaceName = greenSpaceName;
    }

    /**
     * Sets the associated GreenSpace object.
     *
     * @param associatedGreenSpace The GreenSpace to set.
     */
    public void setAssociatedGreenSpace(GreenSpace associatedGreenSpace) {
        this.associatedGreenSpace = associatedGreenSpace;
    }

    @Override
    public String toString() {
        return "ToDoEntry{" +
                "task='" + task + '\'' +
                ", urgency='" + urgency + '\'' +
                ", associatedGreenSpace=" + associatedGreenSpace.getName() +
                ", duration=" + duration +
                ", userEmail='" + userEmail + '\'' +
                ", greenSpaceName='" + greenSpaceName + '\'' +
                '}';
    }
}
