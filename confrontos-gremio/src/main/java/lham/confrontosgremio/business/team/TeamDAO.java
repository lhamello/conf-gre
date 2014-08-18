package lham.confrontosgremio.business.team;

import lham.confrontosgremio.infra.AbstractDAO;

import com.mysema.query.jpa.impl.JPAQuery;

public class TeamDAO extends AbstractDAO<Team, Long> {

    public Team findByName(String commonName) {
        JPAQuery query = new JPAQuery(entityManager);
        QTeam team = QTeam.team;
        
        return query.from(team).where(team.commonName.equalsIgnoreCase(commonName)).uniqueResult(team);
    }

}
