package lham.confrontosgremio.infra;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Abstract Model for entity classes.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <K>
 *            entity's type of primary key.
 */
public abstract class AbstractModel<K> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Returns the unique identifier of the entity (primary key).
     * 
     * @return entity's primary key.
     */
    public abstract K getId();

    /**
     * Sets the unique identifier of the entity (primary key).
     * 
     * @param pk
     *            entity's primary key.
     */
    public abstract void setId(final K pk);

    /**
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE, true);
    }

}
