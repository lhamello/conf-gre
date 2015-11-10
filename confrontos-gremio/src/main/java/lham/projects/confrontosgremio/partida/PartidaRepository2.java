package lham.projects.confrontosgremio.partida;

import java.util.Date;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import lham.projects.confrontosgremio.infra.BaseRepository;

import com.mysema.query.jpa.impl.JPAQuery;

@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PartidaRepository2 extends BaseRepository {

    public Partida inserirPartida(Partida partida) {
        entityManager.persist(partida);
        entityManager.flush();

        return partida;
    }
    
    public void atualizarPartidas(List<Partida> partidas) {
        for (int i = partidas.size() - 1; i >= 0; i--) {
            Partida partida = partidas.get(i);
//            entityManager.de
            partida.setNumero(partida.getNumero() + 1);
            entityManager.merge(partida);
        }
        entityManager.flush();
    }

    public long contarPartidas() {
        jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(QPartida.partida).count();
    }

    public long metodo(Date data, Date horario) {
        jpaQuery = new JPAQuery(entityManager);
        QPartida partida = QPartida.partida;
//        return jpaQuery.from(partida).where(partida.data.loe(data), partida.horario.before(horario)).count();
        return jpaQuery.from(partida).where(partida.data.loe(data)).count();
    }
    
    public List<Partida> buscarPorNumero(Long numero) {
        jpaQuery = new JPAQuery(entityManager);
        QPartida partida = QPartida.partida;
        
        return jpaQuery.from(partida).where(partida.numero.goe(numero)).list(partida);
    }
}
