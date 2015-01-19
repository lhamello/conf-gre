package lham.projects.confrontosgremio.team;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class TeamInsertStepsDef extends TeamContext {
    
    private Team team;
    private boolean teamServiceException;
    
    /*
     * --------------------------------- Configuration
     */

    @Before
    public void initializeScenario() {
        super.createScenario();
        teamServiceException = false;
    }

    @After
    public void finalizeScenario() {
        super.closeConnection();
    }

    /*
     * --------------------------------- Scenarios
     */
    
    @Dado("^que quero efetuar o cadastro de um novo \"(.*?)\"$")
    public void queQueroEfetuarOCadastroDeUmNovo(String teamTemplate) throws Throwable {
        team = new TeamFactory().createTeam(teamTemplate);
    }

    @Quando("^efetuo a operacao de incluir um time$")
    public void efetuoAOperacaoDeIncluirUmTime() throws Throwable {
        try {
            team = teamService.insert(team);
        } catch (RuntimeException ex) {
            teamServiceException = true;
        }
    }

    @Então("^o time cadastrado deve possuir um identificador unico$")
    public void oTimeCadastradoDevePossuirUmIdentificadorUnico() throws Throwable {
        assertNotNull("O time cadastrado deve possuir um identificador único.", team.getUniqueId());
    }

    @Dado("^nao preencho o nome completo$")
    public void naoPreenchoONomeCompleto() throws Throwable {
        team.setFullName(null);
    }

    @Então("^devo receber uma TeamServiceException$")
    public void devoReceberUmaTeamServiceException() throws Throwable {
        assertTrue(teamServiceException);
    }

    @Dado("^nao preencho o nome comum$")
    public void naoPreenchoONomeComum() throws Throwable {
        team.setCommonName(null);
    }
    
    /*
     * --------------------------------- private methods
     */

}
