package lham.projects.confrontosgremio.business.team;

import lham.projects.confrontosgremio.test.AbstractIT;

public class TeamContext extends AbstractIT {

    protected static TeamService teamService;
    private static TeamDAO teamDAO;

    protected final void createScenario() {
        super.startConnection();
        this.prepareScenario();
    }

    protected void insertTeam(String template) {
        Team team = new TeamFactory().createTeam(template);
        teamService.insert(team);
    }

    private void prepareScenario() {
        teamDAO = new TeamDAO();
        teamDAO.setEntityManager(entityManager);

        teamService = new TeamService();
        teamService.setDAO(teamDAO);
    }
}
