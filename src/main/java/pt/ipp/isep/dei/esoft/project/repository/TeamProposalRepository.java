package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.TeamProposal;

import java.util.ArrayList;
import java.util.List;

public class TeamProposalRepository {


        private List<TeamProposal> teamProposals = new ArrayList<>();

        public void add(TeamProposal teamProposal) {
            teamProposals.add(teamProposal);
        }

        public List<TeamProposal> getAll() {
            return new ArrayList<>(teamProposals);
        }

        public TeamProposal getById(int id) {
            if (id >= 0 && id < teamProposals.size()) {
                return teamProposals.get(id);
            }
            return null;
        }


}
