package lham.confrontosgremio.business.match;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import lham.confrontosgremio.business.team.Team;
import lham.confrontosgremio.enums.Confederation;
import lham.confrontosgremio.enums.TeamType;
import lham.confrontosgremio.infra.AbstractController;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

@Named("matchMB")
@ViewAccessScoped
public class MatchController extends AbstractController<Match, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private MatchService matchService;

    @Override
    @PostConstruct
    public void createController() {
        super.setEntity(this.createEntity());
        super.setService(matchService);
    }
    
    @Override
    public String save() {
        super.save();
        return "/index.xhtml?faces-redirect=true";
    }
    
    private Match createEntity() {
        Team team = new Team();
        team.setConfederation(Confederation.CONMEBOL);
        team.setType(TeamType.CLUB);
        
        Match match = new Match();
        match.setOpponent(team);
        
        return match;
    }
    
}
