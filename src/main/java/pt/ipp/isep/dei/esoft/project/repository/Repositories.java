package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static Repositories instance;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
    private final SkillsRepository skillsrepository;
    private Object SkillsRepository;
    private final JobRepository jobrepository;
    private final CollaboratorRepository collaboratorRepository;
    private final TeamProposalRepository teamProposalRepository;

    private Repositories() {
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        skillsrepository = new SkillsRepository();
        jobrepository = new JobRepository();
        collaboratorRepository = new CollaboratorRepository();
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

    public SkillsRepository getSkillRepository() { return (SkillsRepository) SkillsRepository;
    }
    public JobRepository getJobrepository(){return (JobRepository) jobrepository;}

    public TeamProposalRepository getTeamProposalRepository() {return teamProposalRepository;}

    public CollaboratorRepository getCollaboratorRepository() { return collaboratorRepository;}
}