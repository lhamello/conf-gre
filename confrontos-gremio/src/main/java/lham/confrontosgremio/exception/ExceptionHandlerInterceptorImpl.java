package lham.confrontosgremio.exception;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.NoResultException;

import lham.confrontosgremio.util.FacesUtil;

import org.slf4j.Logger;

/**
 * Thic class is responsible for intercepting the exceptions thrown by service
 * class.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@ExceptionHandlerInterceptor
@Interceptor
public class ExceptionHandlerInterceptorImpl {

    @Inject
    private Logger logger;

    /**
     * This method is always invoked before the execution of a method in a
     * service class.
     * <p>
     * Responsible for handling exceptions that occur in these services method.
     * 
     * @param context
     *            invocation context.
     * 
     * @return the result of service method execution.
     */
    @AroundInvoke
    @AroundTimeout
    public Object invoke(final InvocationContext context) throws Exception {
        Object result = null;

        try {
            result = context.proceed();
        } catch (ServiceException srvEx) {
            final String exMessage = srvEx.getMessage();

            FacesUtil.addErrorMessage(exMessage);
            logger.debug(exMessage, srvEx);
        } catch (NoResultException nrEx) {
            logger.debug("Consulta não encontrou dados.", nrEx);
        }

        return result;
    }

}
