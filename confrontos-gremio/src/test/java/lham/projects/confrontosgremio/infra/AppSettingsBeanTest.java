package lham.projects.confrontosgremio.infra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppSettingsBeanTest {

    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";
    private AppSettingsBean bean = new AppSettingsBean();

    @Test
    public void getLayoutTest() {
        String template = bean.getLayout();
        assertEquals("Retorno do método getLayout() deve ser igual o valor de APP_LAYOUT.", APP_LAYOUT, template);
    }
}
