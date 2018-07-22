package lham.projects.confrontosgremio.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(glue = { "lham.projects.confrontosgremio.partida" }, 
                 plugin = { "html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }, 
                 features = { "src/test/resources/cucumber/partida/InserirPartida.feature" }, snippets = SnippetType.CAMELCASE)
@RunWith(Cucumber.class)
public class SuiteCucumberTest {
}
