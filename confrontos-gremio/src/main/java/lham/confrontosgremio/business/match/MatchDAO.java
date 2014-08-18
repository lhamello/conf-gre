package lham.confrontosgremio.business.match;

import java.util.Date;
import java.util.List;

import lham.confrontosgremio.infra.AbstractDAO;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.types.Projections;

public class MatchDAO extends AbstractDAO<Match, Long> {
    
    public List<Match> findByDateGreater(Date date) {
        JPAQuery query = new JPAQuery(entityManager);
        QMatch match = QMatch.match;
        
        return query.from(match).where(match.date.gt(date)).list(match);
    }
    
    public List<Match> findMatchesWithIdDateNumber() {
        JPAQuery query = new JPAQuery(entityManager);
        QMatch match = QMatch.match;
        
        return query.from(match).list(Projections.bean(Match.class, match.id, match.date, match.number));
    }
    
    public List<Match> findMatchesByOpponentWithIdDateNumber(Match entity) {
        JPAQuery query = new JPAQuery(entityManager);
        QMatch match = QMatch.match;
        
        return query.from(match).where(match.opponent.eq(entity.getOpponent())).list(Projections.bean(Match.class, match.id, match.date, match.number, match.numberAgainstOpponent));
    }
    
    public void updateNumber(Match entity) {
        QMatch match = QMatch.match;
        JPAUpdateClause update = new JPAUpdateClause(entityManager, match);
        update.where(match.id.eq(entity.getId())).set(match.number, entity.getNumber()).execute();
    }
    
    public void updateNumberAgainstOpponent(Match entity) {
        QMatch match = QMatch.match;
        JPAUpdateClause update = new JPAUpdateClause(entityManager, match);
        update.where(match.id.eq(entity.getId())).set(match.numberAgainstOpponent, entity.getNumberAgainstOpponent()).execute();
    }
    
}
