package lham.projects.confrontosgremio.team;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import lham.projects.confrontosgremio.infra.AbstractService;

/**
 * Classe de serviço para a entidade {@code Team}. Responsável por gerenciar as
 * regras de negócio desta entidade.
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
     * Construtor vazio padrão.
     */
    public TeamService() {
        super();
    }

    /**
     * Responsável por inicializar a classe <i>DAO</i> utilizada por este
     * serviço, qundo o mesmo é criado.
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
