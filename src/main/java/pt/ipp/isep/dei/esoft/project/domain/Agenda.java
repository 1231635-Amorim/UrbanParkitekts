package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agenda {

    private String team;
    private List<String> equipmentOrVehicles;
    private AgendaStatus status;
    public static List<AgendaEntry> entries;



    public Agenda(String team, List<String> equipmentOrVehicles, AgendaStatus status) {

        this.team = team;
        this.equipmentOrVehicles = equipmentOrVehicles;
        this.status = status;
        this.entries = new ArrayList<>();

    }
    public Agenda() {

    }



    public static void addEntry(AgendaEntry entry) {
        entries.add(entry);
    }

    public List<AgendaEntry> getEntries() {
        return entries;
    }

    public AgendaEntry getEntryById(UUID id) {
        for (AgendaEntry entry : entries) {
            if (entry.getId().equals(id)) {
                return entry;
            }
        }
        return null;
    }

    public String getTeam() {
        return team;
    }

    public List<String> getEquipmentOrVehicles() {
        return equipmentOrVehicles;
    }

    public AgendaStatus getStatus() {
        return status;
    }

    public void setTeam(String team) { // Adicionado método setTeam
        this.team = team;
    }


    public Object getUuid() {
        return null;
    }




    @Override
    public String toString() {
        return "Agenda{" +

                ", team='" + team + '\'' +
                ", equipmentOrVehicles=" + equipmentOrVehicles +
                ", status=" + status +
                '}';
    }





}
