package lham.projects.confrontosgremio.partida;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import lham.projects.confrontosgremio.infra.IService;

/**
 * Servi�o de cadastro e edi��o de partidas.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PartidaService implements IService {

    @Inject
    private PartidaRepository partidaRepository;

    public Partida cadastrarPartida(Partida partida) {
        // define o n�mero da partida que est� sendo cadastrada        
        long numeroPartida = partidaRepository.contarPartidasAntesDe(partida.getData(), partida.getHorario());
        System.out.println("---> DATA: " + partida.getData() + " HORARIO: " + partida.getHorario() + " SIZE: " + numeroPartida);
        partida.setNumero(++numeroPartida);

        // atualizar (incrementar em 1) o n�mero das partidas que tenham n�mero
        // igual ou maior que o da partida que est� sendo cadastrada
        partidaRepository.incrementarNumeroDasPartidasMaiorOuIgualQue(partida.getNumero());
        
        return partidaRepository.inserir(partida);
    }
}
