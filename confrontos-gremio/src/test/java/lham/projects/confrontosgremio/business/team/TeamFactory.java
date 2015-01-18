package lham.projects.confrontosgremio.business.team;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class TeamFactory {
    
    public Team createTeam(String template) {
        this.createTeamFixture();
        return Fixture.from(Team.class).gimme(template);
    }

    private void createTeamFixture() {
        Fixture.of(Team.class).addTemplate("validTeam1", new Rule() {
            {
                add("fullName", "Futebol Clube Teste");
                add("commonName", "Teste");
            }
        });
        Fixture.of(Team.class).addTemplate("validTeam2", new Rule() {
            {
                add("fullName", "Sport Club Teste");
                add("commonName", "Sport");
            }
        });
        Fixture.of(Team.class).addTemplate("validTeam3", new Rule() {
            {
                add("fullName", "Teste Futebol Clube");
                add("commonName", "Teste");
            }
        });
        Fixture.of(Team.class).addTemplate("validTeam4", new Rule() {
            {
                add("fullName", "Associação Esportiva Teste");
                add("commonName", "AS Teste");
            }
        });
    }
}
