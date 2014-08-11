package lham.confrontosgremio.exception;

import javax.ejb.ApplicationException;

/**
 * Defines an exception for service classes.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor method.
     * 
     * @param message
     *            message that will be shown in the exception thrown.
     * 
     * @see java.lang.RuntimeException#RuntimeException(String)
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Constructor method.
     * 
     * @param message
     *            message that will be shown in the exception thrown.
     * 
     * @param ex
     *            exception that caused the creation of this exception.
     * 
     * @see java.lang.RuntimeException#RuntimeException(String, Throwable)
     */
    public ServiceException(final String message, final Exception ex) {
        super(message, ex);
    }

}
