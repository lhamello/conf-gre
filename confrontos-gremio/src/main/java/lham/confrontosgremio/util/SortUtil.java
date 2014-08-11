package lham.confrontosgremio.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Singleton;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.EnumUtils;

@Singleton
public class SortUtil {
        
    private SortUtil() {
        super();
    }
    
    public static <E extends Enum<E>> List<E> sortEnumList(final Class<E> enumClass, final String... fields) {
        return SortUtil.sortListStripAccents(EnumUtils.getEnumList(enumClass), fields);
    }
    
    public static List<String> sortList(final List<String> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        }

        return list;
    }

    public static <T> List<T> sortList(final List<T> list, final String... fields) {
        return sort(list, null, fields);
    }

    public static <T> List<T> sortListStripAccents(final List<T> list, final String... fields) {
        return sort(list, StringComparator.getInstance(), fields);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> List<T> sort(final List<T> list, final Comparator<String> comparator, final String... fields) {
        if (CollectionUtils.isNotEmpty(list) && fields != null) {

            for (String string : fields) {
                Collections.sort(list, new BeanComparator(string, comparator));
            }
        }

        return list;
    }

}
