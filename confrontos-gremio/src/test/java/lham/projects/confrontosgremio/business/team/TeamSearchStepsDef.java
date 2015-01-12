package lham.projects.confrontosgremio.business.team;

import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent„o;
import cucumber.api.java.pt.Quando;

public class TeamSearchStepsDef extends TeamContext {

    private List<Team> result;
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

    @Dado("^preencho o filtro nome completo com um valor existente$")
    public void preenchoOFiltroNomeCompletoComUmValorExistente() throws Throwable {
        filter = new Team();
        filter.setFullName("Teste Futebol Clube");
    }

    @Quando("^efetuo a pesquisa de times$")
    public void efetuoAPesquisaDeTimes() throws Throwable {
        result = teamService.find(filter);
    }

    @Ent„o("^s„o apresentados os registros correspondentes ao filtro informado$")
    public void s„oApresentadosOsRegistrosCorrespondentesAoFiltroInformado() throws Throwable {
        boolean condition = (result.size() == numberOfTeams);
        assertTrue("S„o apresentados os registros correspondetes ao filtro informado.", condition);
    }

    @Dado("^preencho o filtro nome completo com um valor inexistente$")
    public void preenchoOFiltroNomeCompletoComUmValorInexistente() throws Throwable {
        filter = new Team();
        filter.setFullName("ABC");
    }

    @Ent„o("^nenhum registro È retornado pela pesquisa$")
    public void nenhumRegistro…RetornadoPelaPesquisa() throws Throwable {
        boolean condition = (result.size() == 0);
        assertTrue("Nenhum registro È retornado pela pesquisa.", condition);
    }

    @Dado("^preencho o filtro nome comum com um valor existente$")
    public void preenchoOFiltroNomeComumComUmValorExistente() throws Throwable {
        filter = new Team();
        filter.setCommonName("Teste");
    }

    @Dado("^preencho o filtro nome comum com um valor inexistente$")
    public void preenchoOFiltroNomeComumComUmValorInexistente() throws Throwable {
        filter = new Team();
        filter.setCommonName("ABC");
    }
}
