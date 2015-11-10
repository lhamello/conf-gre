package lham.projects.confrontosgremio.infra;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Define o layout base usado pelas páginas da aplicação.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Named(value = "layoutController")
@RequestScoped
public class LayoutController {

    /**
     * Constante que indica o layout usado pela aplicação.
     */
    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";

    /**
     * Reporna o layout base usado pela aplicação.
     * 
     * @return o valor do layout base da aplicação.
     */
    public String getLayout() {
        return APP_LAYOUT;
    }
}
