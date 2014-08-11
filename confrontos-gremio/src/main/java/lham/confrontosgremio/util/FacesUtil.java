package lham.confrontosgremio.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Singleton;

/**
 * Class responsible for adding messages to JSF context.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Singleton
public final class FacesUtil {

    /**
     * Private constructor method.
     */
    private FacesUtil() {
        super();
    }

    /**
     * Add error message to JSF context.
     * 
     * @param message
     *            message that will be added.
     */
    public static void addErrorMessage(final String message) {
        addMessageInContext(getContext(), FacesMessage.SEVERITY_ERROR, message);
    }

    /**
     * Returns the JSF context.
     * 
     * @return JSF context.
     */
    private static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Add error message to JSF context.
     * 
     * @param context
     *            JSF context.
     * 
     * @param severity
     *            severity of the message.
     * 
     * @param message
     *            message that will be added.
     */
    private static void addMessageInContext(final FacesContext context, final Severity severity, final String message) {
        context.addMessage(null, new FacesMessage(severity, null, message));
    }

}
