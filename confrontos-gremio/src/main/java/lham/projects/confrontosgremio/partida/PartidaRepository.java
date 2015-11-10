package lham.projects.confrontosgremio.partida;

import java.util.Date;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import lham.projects.confrontosgremio.infra.IRepository;
import lham.projects.confrontosgremio.infra.Persistencia;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.query.ListSubQuery;

@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PartidaRepository implements IRepository {

    @Inject
    private Persistencia persistencia;

    public long contarPartidasAntesDe(Date data, Date horario) {
        JPAQuery query = persistencia.criarJpaQuery();
        QPartida partida = QPartida.partida;
        
        ListSubQuery<Long> partidas1 = new JPASubQuery().from(partida).where(partida.data.before(data)).list(partida.id);
        ListSubQuery<Long> partidas2;

        if (horario != null) {
            partidas2 = new JPASubQuery().from(partida).where(partida.data.eq(data), partida.horario.loe(horario)).list(partida.id);
        } else {
            partidas2 = new JPASubQuery().from(partida).where(partida.data.eq(data)).list(partida.id);
        }

        return query.from(partida).where(partida.id.in(partidas1).or(partida.id.in(partidas2))).count();
    }

    public void incrementarNumeroDasPartidasMaiorOuIgualQue(Long numero) {
        JPAQuery query = persistencia.criarJpaQuery();
        QPartida qPartida = QPartida.partida;

        List<Partida> listaPartidas = query.from(qPartida).where(qPartida.numero.goe(numero)).list(qPartida);

        for (int i = (listaPartidas.size() - 1); i >= 0; i--) {
            Partida partida = listaPartidas.get(i);
            partida.setNumero(partida.getNumero() + 1);
            persistencia.atualizar(partida);
        }
    }

    public Partida inserir(Partida partida) {
        return (Partida) persistencia.inserir(partida);
    }
}
