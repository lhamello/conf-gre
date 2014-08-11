package lham.confrontosgremio.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for reading messages from the message bundle.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Singleton
public final class MessageBundleUtil {

    private static final String PREFIX_SUFIX = "<???>";
    
    private static Logger logger = LoggerFactory.getLogger(MessageBundleUtil.class);
    private static ResourceBundle resourceBundle;
    
    /**
     * Private constructor method.
     */
    private MessageBundleUtil() {
        super();
    }
    
    /**
     * 
     * Looking for a message in the message bundle from a key informed.
     * 
     * @param key
     *            key for the search.
     * 
     * @return the value the value for the informed key or, if the key not
     *         found, returns the String: &lt;???&gt;{@code key}&lt;???&gt;
     */
    public static String getMessage(final String key) {
        final StringBuilder message = new StringBuilder();

        try {
            message.append(getResourceBundle().getString(key));
        } catch (MissingResourceException ex) {
            message.append(PREFIX_SUFIX).append(key).append(PREFIX_SUFIX);
            logger.warn("Chave não encontrada no arquivo de properties", ex);
        }

        return message.toString();
    }
    
    /**
     * 
     * Looking for a message in the message bundle from a key and param
     * informed.
     * 
     * @param key
     *            key for the search.
     * 
     * @param params
     *            parameters that will be added to the message.
     * 
     * @return the value the value for the informed key or, if the key not
     *         found, returns the String: &lt;???&gt;{@code key}&lt;???&gt;
     */
    public static String getMessage(final String key, final Object... params) {
        final String message = getMessage(key);

        return MessageFormat.format(message, params);
    }

    private static ResourceBundle getResourceBundle() {
        synchronized (MessageBundleUtil.class) {
            if (resourceBundle == null) {
                resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
            }
        }

        return resourceBundle;
    }
    
}
