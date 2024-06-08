package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;

public class Repositories {

    private static Repositories instance;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
    private final JobRepository jobRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final SkillsRepository skillsRepository;
    private final GreenSpaceRepository greenSpaceRepository;
    private final TeamProposalRepository teamProposalRepository;


    private Repositories() {
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        jobRepository = new JobRepository();
        collaboratorRepository = new CollaboratorRepository();
        skillsRepository = new SkillsRepository();
        greenSpaceRepository = new GreenSpaceRepository();
        teamProposalRepository = new TeamProposalRepository();
    }

    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                instance = new Repositories();
            }
        }
        return instance;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public JobRepository getJobRepository() {
        return jobRepository;
    }

    public CollaboratorRepository getCollaboratorRepository() { return collaboratorRepository; }

    public SkillsRepository getSkillRepository() {
        return skillsRepository;
    }
    public GreenSpaceRepository getGreenSpaceRepository() {
        return greenSpaceRepository;
    }
    public TeamProposalRepository getTeamProposalRepository() { return teamProposalRepository;}
}