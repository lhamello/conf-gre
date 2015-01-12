package lham.projects.confrontosgremio.business.team;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import lham.projects.confrontosgremio.infra.AbstractService;

/**
 * Classe de serviço para a entidade {@code Team}. Responsável por gerenciar a
 * regra de negócio desta entidade.
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
     * Responsável por inicializar a classe <i>DAO</i> utilizada por este
     * serviço, qundo o mesmo é criado.
     */
    @Override
    @PostConstruct
    public void initDAO() {
        super.setDAO(teamDAO);
    }
}
