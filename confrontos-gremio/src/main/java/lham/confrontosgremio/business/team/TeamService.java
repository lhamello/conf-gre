package lham.confrontosgremio.business.team;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import lham.confrontosgremio.exception.ExceptionHandlerInterceptor;
import lham.confrontosgremio.infra.AbstractService;

@Default
@ExceptionHandlerInterceptor
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TeamService extends AbstractService<Team, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private TeamDAO teamDAO;

    @Override
    @PostConstruct
    public void initDAO() {
        super.setDAO(teamDAO);
    }
    
    public Team findByName(Team team) {
        return teamDAO.findByName(team.getCommonName());
    }
    
}
