package pt.ipp.isep.dei.esoft.project.domain;

public class ToDoEntry {
    private String urgency;
    private GreenSpace associatedGreenSpace;
    private Long duration;

    public ToDoEntry(String urgency, GreenSpace associatedGreenSpace, Long duration) {
        this.urgency = urgency;
        this.associatedGreenSpace = associatedGreenSpace;
        this.duration = duration;
    }

    public String getUrgency() {
        return urgency;
    }

    public GreenSpace getAssociatedGreenSpace() {
        return associatedGreenSpace;
    }

    public Long getDuration() {
        return duration;
    }

    public void setUrgency(String urgency){
        this.urgency =urgency;
    }

    public void setDuration(Long duration){
        this.duration =duration;
    }

    public void setAssociatedGreenSpace(GreenSpace associatedGreenSpace){
        this.associatedGreenSpace =associatedGreenSpace;
    }

    @Override
    public String toString() {
        return "ToDoEntry{" +
                "urgency='" + urgency + '\'' +
                ", associatedGreenSpace=" + associatedGreenSpace.getName() +
                '}';
    }
}
