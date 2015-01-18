package lham.projects.confrontosgremio.business.team;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/cucumber/team/TeamList.feature", "src/test/resources/cucumber/team/TeamSearch.feature" }, snippets = SnippetType.CAMELCASE)
public class TeamTest {

}