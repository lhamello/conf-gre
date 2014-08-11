package lham.confrontosgremio.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Configure the preferences application.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Named(value = "appSettingsMB")
@RequestScoped
public class AppSettingsController {

    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";

    /**
     * Returns the base application layout.
     * 
     * @return the base application layout.
     */
    public String getLayout() {
        return APP_LAYOUT;
    }

}
