package lham.projects.confrontosgremio.business.team;

import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent„o;
import cucumber.api.java.pt.Quando;

public class TeamSearchStepsDef extends TeamContext {

    private static final String NONEXISTENT_VALUE = "###123";
    private int teamsExpected;
    private List<Team> result;
    private String searchFilter;
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
        this.setFullNameFilter("Teste Futebol Clube");
        teamsExpected = 1;
    }

    @Quando("^efetuo a pesquisa de times$")
    public void efetuoAPesquisaDeTimes() throws Throwable {
        result = teamService.find(filter);
    }

    @Ent„o("^s„o apresentados os registros correspondentes ao filtro informado$")
    public void s„oApresentadosOsRegistrosCorrespondentesAoFiltroInformado() throws Throwable {
        int numberOfTeams = result.size();
        assertTrue("S„o apresentados os registros correspondetes ao filtro informado.", numberOfTeams == teamsExpected);
    }

    @Dado("^preencho o filtro nome completo com um valor inexistente$")
    public void preenchoOFiltroNomeCompletoComUmValorInexistente() throws Throwable {
        this.setFullNameFilter(NONEXISTENT_VALUE);
    }

    @Ent„o("^nenhum registro È retornado pela pesquisa$")
    public void nenhumRegistro…RetornadoPelaPesquisa() throws Throwable {
        int numberOfTeams = result.size();
        assertTrue("Nenhum registro È retornado pela pesquisa.", numberOfTeams == 0);
    }

    @Dado("^preencho o filtro nome comum com um valor existente$")
    public void preenchoOFiltroNomeComumComUmValorExistente() throws Throwable {
        this.setCommonNameFilter("Teste");
        teamsExpected = 3;
    }

    @Dado("^preencho o filtro nome comum com um valor inexistente$")
    public void preenchoOFiltroNomeComumComUmValorInexistente() throws Throwable {
        this.setCommonNameFilter(NONEXISTENT_VALUE);
    }

    /*
     * --------------------------------- private methods
     */

    private void setCommonNameFilter(String filterValue) {
        this.setFilter(filterValue);
        filter.setCommonName(searchFilter);
    }

    private void setFullNameFilter(String filterValue) {
        this.setFilter(filterValue);
        filter.setFullName(searchFilter);
    }

    private void setFilter(String filterValue) {
        searchFilter = filterValue;
        filter = new Team();
    }
}
