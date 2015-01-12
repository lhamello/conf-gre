package lham.projects.confrontosgremio.business.team;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class TeamFactory {

    public Team createTeam() {
        this.createTeamFixture();
        return Fixture.from(Team.class).gimme("");
    }

    private void createTeamFixture() {
        Fixture.of(Team.class).addTemplate("", new Rule() {
            {
                add("fullName", "Teste Futebol Clube");
                add("commonName", "Teste");
            }
        });
    }
}
