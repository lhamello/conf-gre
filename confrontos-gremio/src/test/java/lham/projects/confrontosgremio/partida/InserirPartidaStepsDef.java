package lham.projects.confrontosgremio.partida;

import java.text.SimpleDateFormat;

import lham.projects.confrontosgremio.infra.Persistencia;
import lham.projects.confrontosgremio.test.ConectorBaseDados;
import lham.projects.confrontosgremio.test.ServiceRepositoryUtil;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class InserirPartidaStepsDef {

    private Partida partida;
    private PartidaService partidaService;

    /*
     * --------------------------------- Configuration
     */

    @Before
    public void initializeScenarios() {
        Persistencia persistencia = ConectorBaseDados.iniciarConexao();

        PartidaRepository partidaRepository = new PartidaRepository();
        partidaService = new PartidaService();

        ServiceRepositoryUtil.inicializarPersistenciaDoRepositorio(partidaRepository, persistencia);
        ServiceRepositoryUtil.inicializarRepositoryDoService(partidaService, partidaRepository, "partidaRepository");
    }

    @After
    public void finalizeScenarios() {
        ConectorBaseDados.encerrarConexao();
    }

    /*
     * --------------------------------- Scenarios
     */

    @Dado("^que crio uma nova partida$")
    public void queCrioUmaNovaPartida() throws Throwable {
        this.partida = new Partida();
    }

    @Dado("^não existem partidas cadastradas no banco de dados$")
    public void nãoExistemPartidasCadastradasNoBancoDeDados() throws Throwable {
        // sem ação, não há partidas cadastradas no banco de testes
    }

    @Dado("^preencho o campo data com valor \"(.*?)\"$")
    public void preenchoOCampoDataComValor(String data) throws Throwable {
        partida.setData(new SimpleDateFormat("dd/MM/yyyy").parse(data));
    }

    @Dado("^preencho o campo horario com valor \"(.*?)\"$")
    public void preenchoOCampoHorarioComValor(String horario) throws Throwable {
        partida.setHorario(new SimpleDateFormat("HH:mm").parse(horario));
    }

    @Quando("^uma nova partida for cadastrada no banco de dados$")
    public void umaNovaPartidaForCadastradaNoBancoDeDados() throws Throwable {
        partidaService.cadastrarPartida(partida);
    }

    @Entao("^ela deve possuir numero igual à (\\d+)$")
    public void elaDevePossuirNumeroIgualÀ(Long numero) throws Throwable {
        Assert.assertEquals("Número da partida está incorreto!", numero, partida.getNumero());
    }

    @Dado("^existem partidas cadastradas no banco de dados$")
    public void existemPartidasCadastradasNoBancoDeDados() throws Throwable {
        partidaService.cadastrarPartida(PartidaFactory.criarPartida("partida1"));
        partidaService.cadastrarPartida(PartidaFactory.criarPartida("partida2"));
        partidaService.cadastrarPartida(PartidaFactory.criarPartida("partida3"));
        partidaService.cadastrarPartida(PartidaFactory.criarPartida("partida3"));
    }

    @Dado("^preencho o campo horario com valor null$")
    public void preenchoOCampoHorarioComValorNull() throws Throwable {
        partida.setHorario(null);
    }
}
