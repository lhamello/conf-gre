package lham.projects.confrontosgremio.partida;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import lham.projects.confrontosgremio.infra.IService;

/**
 * Serviço de cadastro e edição de partidas.
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
        // define o número da partida que está sendo cadastrada        
        long numeroPartida = partidaRepository.contarPartidasAntesDe(partida.getData(), partida.getHorario());
        System.out.println("---> DATA: " + partida.getData() + " HORARIO: " + partida.getHorario() + " SIZE: " + numeroPartida);
        partida.setNumero(++numeroPartida);

        // atualizar (incrementar em 1) o número das partidas que tenham número
        // igual ou maior que o da partida que está sendo cadastrada
        partidaRepository.incrementarNumeroDasPartidasMaiorOuIgualQue(partida.getNumero());
        
        return partidaRepository.inserir(partida);
    }
}
