package lham.projects.confrontosgremio.partida;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class PartidaFactory {

    public static Partida criarPartida(String template) {
        PartidaFactory.criarFixture();
        return Fixture.from(Partida.class).gimme(template);
    }

    private static void criarFixture() {
        try {
            Fixture.of(Partida.class).addTemplate("partida1", new Rule() {
                {
                    add("data", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/07/1986 20:00"));
                    add("horario", new SimpleDateFormat("HH:mm").parse("20:00"));
                }
            });
            Fixture.of(Partida.class).addTemplate("partida2", new Rule() {
                {
                    add("data", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/07/1986 22:00"));
                    add("horario", new SimpleDateFormat("HH:mm").parse("22:00"));
                }
            });
            Fixture.of(Partida.class).addTemplate("partida3", new Rule() {
                {
                    add("data", new SimpleDateFormat("dd/MM/yyyy").parse("04/07/1986"));
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
