package lham.projects.confrontosgremio.business.team;

import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class TeamListStepsDef extends TeamContext {

    private List<Team> result;
    private int numberOfTeams;
    private Team filter;

    /*
     * --------------------------------- Configuration
     */

    @Before
    public void initializeScenario() {
        super.createScenario();
    }

    @After
    public void finalizeScenario() {
        super.closeConnection();
    }

    /*
     * --------------------------------- Scenarios
     */

    @Dado("^que não existam times cadastrados$")
    public void queNãoExistamTimesCadastrados() throws Throwable {
        filter = new Team();
    }

    @Quando("^eu acesso a listagem de times$")
    public void euAcessoAListagemDeTimes() throws Throwable {
        result = teamService.find(filter);
    }

    @Então("^devo receber uma lista vazia como resposta$")
    public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
        assertTrue("Devo receber uma lista vazia como resposta.", result.isEmpty());
    }

    @Dado("^que existam times cadastrados$")
    public void queExistamTimesCadastrados() throws Throwable {
        this.insertTeams();
        filter = new Team();
    }

    @Então("^devo receber uma lista com todos times cadastrados$")
    public void devoReceberUmaListaComTodosTimesCadastrados() throws Throwable {
        boolean condition = (result.size() == numberOfTeams);
        assertTrue("Devo receber uma lista com todos times cadastrados.", condition);
    }
    
    private void insertTeams() {
        numberOfTeams = 4;
        
        super.insertTeam("validTeam1");
        super.insertTeam("validTeam2");
        super.insertTeam("validTeam3");
        super.insertTeam("validTeam4");
    }
}
