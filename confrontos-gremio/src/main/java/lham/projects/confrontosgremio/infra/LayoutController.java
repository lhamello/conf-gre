package lham.projects.confrontosgremio.infra;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Define o layout base usado pelas p�ginas da aplica��o.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Named(value = "layoutController")
@RequestScoped
public class LayoutController {

    /**
     * Constante que indica o layout usado pela aplica��o.
     */
    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";

    /**
     * Reporna o layout base usado pela aplica��o.
     * 
     * @return o valor do layout base da aplica��o.
     */
    public String getLayout() {
        return APP_LAYOUT;
    }
}
