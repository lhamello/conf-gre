package lham.projects.confrontosgremio.partida;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PartidaService2 {

    @Inject
    private PartidaRepository2 partidaRepository;

    public Partida cadastrarPartida(Partida partida) {
        this.definirNumeroPartida(partida);
        
        partidaRepository.atualizarPartidas(partidaRepository.buscarPorNumero(partida.getNumero()));
        
        return partidaRepository.inserirPartida(partida);
    }

    public void setPartidaRepository(PartidaRepository2 partidaRepository) {
        this.partidaRepository = partidaRepository;
    }
    
    public void definirNumeroPartida(Partida partida) {
        System.out.println("N: " + partidaRepository.contarPartidas());
        
        long number = partidaRepository.metodo(partida.getData(), partida.getHorario());
        System.out.println("NUMBER: " + number);
//        BigInteger result = number.add(new BigInteger("1"));
        partida.setNumero(++number);
        System.out.println("NUMBER get: " + partida.getNumero());
    }
}
