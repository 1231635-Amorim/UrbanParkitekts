package pt.ipp.isep.dei.esoft.project.domain;


import java.io.Serializable;
import java.util.List;

public class TeamProposal implements Serializable {
        private int maxSize;
        private int minSize;
        private List<String> requiredSkills;
        private List<Collaborator> proposedTeam;

        public TeamProposal(int maxSize, int minSize, List<String> requiredSkills, List<Collaborator> proposedTeam) {
            this.maxSize = maxSize;
            this.minSize = minSize;
            this.requiredSkills = requiredSkills;
            this.proposedTeam = proposedTeam;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getMinSize() {
            return minSize;
        }

        public List<String> getRequiredSkills() {
            return requiredSkills;
        }

        public List<Collaborator> getProposedTeam() {
            return proposedTeam;
        }

    public void setProposedTeam(List<Collaborator> proposedTeam) {
        this.proposedTeam = proposedTeam;
    }

    @Override
    public String toString() {
        return "TeamProposal{" +
                "maxSize=" + maxSize +
                "minSize=" + minSize +
                ", requiredSkills=" + requiredSkills +
                ", proposedTeam=" + proposedTeam +
                '}';
    }
}




