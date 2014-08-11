package lham.confrontosgremio.util;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

public final class StringComparator implements Comparator<String>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final StringComparator INSTANCE = new StringComparator();
    
    private StringComparator() {
        super();
    }
    
    public static StringComparator getInstance() {
        return INSTANCE;
    }

    public int compare(final String obj1, final String obj2) {
        final String name1 = StringUtils.stripAccents(obj1);
        final String name2 = StringUtils.stripAccents(obj2);
        
        return (name1).compareTo(name2);
    }

    @Override
    public int hashCode() {
        return "StringComparator".hashCode();
    }

    @Override
    public boolean equals(final Object object) {
        return (this == object) || ((null != object) && (object.getClass().equals(this.getClass())));
    }

}
