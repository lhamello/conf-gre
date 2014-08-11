package lham.confrontosgremio.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producess class of injection beans.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class ProducesUtil {

    /**
     * Producess an {@code Logger} object.
     * 
     * @param injectionPoint
     *            injection point.
     * 
     * @return an {@code Logger} object to be injected.
     */
    @Produces
    public Logger loggerProduces(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getCanonicalName());
    }

}
