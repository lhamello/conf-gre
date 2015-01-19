package lham.projects.confrontosgremio.team;

import javax.inject.Named;

import lham.projects.confrontosgremio.infra.BaseBean;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

@Named("teamBean")
@ViewAccessScoped
public class TeamBean extends BaseBean<Team, Long> {

    private static final long serialVersionUID = 1L;

}
