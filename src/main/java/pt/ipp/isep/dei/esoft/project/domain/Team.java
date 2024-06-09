package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<String> memberEmails;

    public Team(String name) {
        this.name = name;
        this.memberEmails = new ArrayList<>();
    }

    public void addMemberEmail(String email) {
        memberEmails.add(email);
    }

    public List<String> getMemberEmails() {
        return memberEmails;
    }
}
