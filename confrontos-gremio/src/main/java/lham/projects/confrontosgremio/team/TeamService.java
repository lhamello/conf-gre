package lham.projects.confrontosgremio.team;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import lham.projects.confrontosgremio.infra.AbstractService;

/**
 * Classe de servi�o para a entidade {@code Team}. Respons�vel por gerenciar as
 * regras de neg�cio desta entidade.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TeamService extends AbstractService<Team, Long> {

    private static final long serialVersionUID = 1L;
    @Inject
    private transient TeamDAO teamDAO;

    /**
     * Construtor vazio padr�o.
     */
    public TeamService() {
        super();
    }

    /**
     * Respons�vel por inicializar a classe <i>DAO</i> utilizada por este
     * servi�o, qundo o mesmo � criado.
     */
    @Override
    @PostConstruct
    public final void initDAO() {
        super.setDAO(teamDAO);
    }
    
    public Team insert(Team team) {
        if (team.getFullName() == null) {
            throw new RuntimeException();
        }
        
        if (team.getCommonName() == null) {
            throw new RuntimeException();
        }
        
        return teamDAO.insert(team);
    }
    
    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }
}
