package lham.projects.confrontosgremio.business.team;

import java.util.Random;

import lham.projects.confrontosgremio.infra.IntegrationTestInfra;

public class TeamContext extends IntegrationTestInfra {

    protected static TeamService teamService;
    protected static int numberOfTeams;
    private static TeamDAO teamDAO;

    protected final void createScenario() {
        super.startConnection();
        this.prepareScenario();
    }

    protected void insertTeam() {
        Random rd = new Random(10);
        int teamsInserted = rd.nextInt(10) + 1;

        for (int i = 0; i < teamsInserted; i++) {
            Team team = new TeamFactory().createTeam();

            teamService.insert(team);
        }

        numberOfTeams = teamsInserted;
    }

    private void prepareScenario() {
//        if (teamDAO == null) {
            teamDAO = new TeamDAO();
            teamDAO.setEntityManager(entityManager);

            teamService = new TeamService();
            teamService.setDAO(teamDAO);
//        }
    }
}
