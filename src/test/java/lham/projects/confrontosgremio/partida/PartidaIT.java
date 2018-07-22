package lham.projects.confrontosgremio.partida;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/cucumber/partida/InserirPartida.feature" }, snippets = SnippetType.CAMELCASE)
public class PartidaIT {

}
