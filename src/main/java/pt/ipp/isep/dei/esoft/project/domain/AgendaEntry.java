package pt.ipp.isep.dei.esoft.project.domain;


import java.time.LocalDate;
import java.util.UUID;

public class AgendaEntry {
        private ToDoEntry toDoEntry;
        private String team;
        private String vehiclesEquipment;
        private String timeInterval;
        private LocalDate date;
        private String status;
        private String useremail;
        private boolean pending;
    private final UUID id;

        public AgendaEntry(ToDoEntry toDoEntry, String team, String vehiclesEquipment, String timeInterval, LocalDate date, String status) {
            this.id = UUID.randomUUID();
            this.toDoEntry = toDoEntry;
            this.team = team;
            this.vehiclesEquipment = vehiclesEquipment;
            this.timeInterval = timeInterval;
            this.date = date;
            this.status = status;
        }

    public ToDoEntry getToDoEntry() {
        return toDoEntry;
    }

    public String getTeam() {
        return team;
    }

    public String getVehiclesEquipment() {
        return vehiclesEquipment;
    }
    public String getTimeInterval() {return timeInterval;}

    public LocalDate getDate() {return date;}

    public String getStatus() {return status;}

    public void setToDoEntry(ToDoEntry toDoEntry) {
        this.toDoEntry = toDoEntry;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void setVehiclesEquipment(String vehiclesEquipment) {
        this.vehiclesEquipment = vehiclesEquipment;
    }

    public String getUserEmail() {return useremail;
    }

    public boolean isPending() {
        return pending;
    }
    public UUID getId() {
        return id;
    }
}


