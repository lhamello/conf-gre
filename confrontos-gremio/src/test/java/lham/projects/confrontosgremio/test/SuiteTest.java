package lham.projects.confrontosgremio.test;

import lham.projects.confrontosgremio.infra.AppSettingsBeanUT;
import lham.projects.confrontosgremio.team.TeamIT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppSettingsBeanUT.class, TeamIT.class })
public class SuiteTest {
}
