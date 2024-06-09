package pt.ipp.isep.dei.esoft.project.domain;

public class ToDoEntry {
    private String urgency;
    private GreenSpace associatedGreenSpace;
    private Long duration;
    private String task;
    private String userEmail; // Adicione o email do usuário
    private String greenSpaceName;// Adicione o nome do espaço verde
    private boolean pending;
    /**
     * Construtor da classe ToDoEntry
     *
     * @param urgency             A urgência da tarefa
     * @param associatedGreenSpace O espaço verde associado à tarefa
     * @param duration            A duração da tarefa
     * @param task                A descrição da tarefa
     * @param userEmail           O email do usuário associado à tarefa
     * @param greenSpaceName      O nome do espaço verde associado à tarefa
     */
    public ToDoEntry(String urgency, GreenSpace associatedGreenSpace, Long duration, String task, String userEmail, String greenSpaceName) {
        this.urgency = urgency;
        this.associatedGreenSpace = associatedGreenSpace;
        this.duration = duration;
        this.task = task;
        this.userEmail = userEmail;
        this.greenSpaceName = greenSpaceName;
    }

    public ToDoEntry(String taskDescription, String userEmail, boolean pending) {
    }

    public ToDoEntry(String taskDescription) {
        this.task = taskDescription;
    }


    /**
     * gets the urgency of the entry
     *
     * @return the urgency
     */

    public String getUrgency() {
        return urgency;
    }

    /**
     * gets the urgency of the entry
     *
     * @return the urgency
     */

    public  String getTask(){
        return task;
    }

    /**
     * gets the green space associated with the entry
     *
     * @return the green space associated with the entry
     */

    public GreenSpace getAssociatedGreenSpace() {
        return associatedGreenSpace;
    }

    /**
     * gets the duration of the entry
     *
     * @return the duaration
     */
    /**
     * Sets the email of the user associated with the task.
     *
     * @param userEmail The user email to set.
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
    public Long getDuration() {
        return duration;
    }

    /**
     * sets the urgrncy
     *
     * @param urgency
     */

    public void setUrgency(String urgency){
        this.urgency =urgency;
    }

    /**
     * sets the duration
     * @param duration
     */

    public void setDuration(Long duration){
        this.duration =duration;
    }

    /**
     * sets the duration
     * @param
     */

    public void setTask(String task){
        this.task=task;
    }


    /**
     * Obtém o email do usuário associado à tarefa.
     *
     * @return O email do usuário
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Obtém o nome do espaço verde associado à tarefa.
     *
     * @return O nome do espaço verde
     */
    public String getGreenSpaceName() {
        return greenSpaceName;
    }

    /**
     * sets the associated green space
     * @param associatedGreenSpace
     */

    public void setAssociatedGreenSpace(GreenSpace associatedGreenSpace){
        this.associatedGreenSpace =associatedGreenSpace;
    }

    /**
     * method for the user to enter the details
     * @return
     */

    @Override
    public String toString() {
        return "ToDoEntry{" +
                "task=" + task + '\'' +
                "urgency='" + urgency + '\'' +
                ", associatedGreenSpace=" + associatedGreenSpace.getName() +
                '}';
    }

    public boolean isPending() {
        return pending;
    }

    public String getTaskDescription() { return task;
    }
}
