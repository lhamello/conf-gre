package lham.confrontosgremio.business.match;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import lham.confrontosgremio.business.team.Team;
import lham.confrontosgremio.business.team.TeamService;
import lham.confrontosgremio.exception.ExceptionHandlerInterceptor;
import lham.confrontosgremio.infra.AbstractService;

@Default
@ExceptionHandlerInterceptor
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MatchService extends AbstractService<Match, Long> {

    private static final long serialVersionUID = 1L;

    @Inject
    private MatchDAO matchDAO;
    
    @Inject
    private TeamService teamService;
    
    @Override
    @PostConstruct
    public void initDAO() {
        super.setDAO(matchDAO);
    }

    @Override
    public Match insert(final Match entity) {
        entity.setOpponent(this.verifyTeam(entity.getOpponent()));
        List<Match> matches = this.calcutesMatchNumber(entity);
        
        for (Match match : matches) {
            matchDAO.updateNumber(match);
        }
        
        matches = this.calcutesMatchNumberAgainstOpponent(entity);
        
        for (Match match : matches) {
            matchDAO.updateNumberAgainstOpponent(match);
        }
        
        return super.insert(entity);
    }
    
    private Team verifyTeam(Team team) {
        Team answer = teamService.findByName(team);
        
        if (answer == null) {
            team = teamService.insert(team);
        } else {
            team = answer;
        }
        
        return team;
    }
    
    private List<Match> calcutesMatchNumber(Match entity) {
        List<Match> matches = matchDAO.findMatchesWithIdDateNumber();
        List<Match> updatedMatches = new LinkedList<>();
        
        long cont = 1;
        
        for (Match match : matches) {
            Date matchDate = match.getDate();
            
            if (matchDate.after(entity.getDate())) {
                Long number = match.getNumber();
                number += 1;
                
                match.setNumber(number);
                updatedMatches.add(match);
            } else {
                cont++;
            }
        }
        
        entity.setNumber(cont);
        
        return updatedMatches;
    }
    
    private List<Match> calcutesMatchNumberAgainstOpponent(Match entity) {
        List<Match> matches = matchDAO.findMatchesByOpponentWithIdDateNumber(entity);
        List<Match> updatedMatches = new LinkedList<>();
        
        long cont = 1;
        
        for (Match match : matches) {
            Date matchDate = match.getDate();
            
            if (matchDate.after(entity.getDate())) {
                Long number = match.getNumberAgainstOpponent();
                number += 1;
                
                match.setNumberAgainstOpponent(number);
                updatedMatches.add(match);
            } else {
                cont++;
            }
        }
        
        entity.setNumberAgainstOpponent(cont);
        
        return updatedMatches;
    }
    
}
