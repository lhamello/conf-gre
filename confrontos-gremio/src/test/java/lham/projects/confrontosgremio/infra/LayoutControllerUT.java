package lham.projects.confrontosgremio.infra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LayoutControllerUT {

    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";
    private LayoutController bean = new LayoutController();

    @Test
    public void shouldReturnCorrectLayout() {
        String template = bean.getLayout();
        assertEquals("Expected layout error.", APP_LAYOUT, template);
    }
}
