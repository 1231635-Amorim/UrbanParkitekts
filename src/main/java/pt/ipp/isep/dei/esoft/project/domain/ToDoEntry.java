package pt.ipp.isep.dei.esoft.project.domain;

public class ToDoEntry {
    private String urgency;
    private GreenSpace associatedGreenSpace;
    private Long duration;


    /**
     * default constructor
     *
     * @param urgency
     * @param associatedGreenSpace
     * @param duration
     */

    public ToDoEntry(String urgency, GreenSpace associatedGreenSpace, Long duration) {
        this.urgency = urgency;
        this.associatedGreenSpace = associatedGreenSpace;
        this.duration = duration;
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
                "urgency='" + urgency + '\'' +
                ", associatedGreenSpace=" + associatedGreenSpace.getName() +
                '}';
    }
}
