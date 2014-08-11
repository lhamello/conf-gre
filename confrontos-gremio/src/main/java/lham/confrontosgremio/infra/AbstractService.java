package lham.confrontosgremio.infra;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import lham.confrontosgremio.exception.ServiceException;
import lham.confrontosgremio.util.MessageBundleUtil;

/**
 * Abstract class for services classes.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entity that is managed by this class. This entity shall extend the
 *            class {@code AbstractModel}.
 * 
 * @param <K>
 *            entity's primary key type <i>E</i> managed by this class.
 * 
 * @see lham.confrontosgremio.infra.AbstractModel
 */
public abstract class AbstractService<E extends AbstractModel<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;

    private AbstractDAO<E, K> dao;

    /**
     * Sets DAO.
     */
    @PostConstruct
    public abstract void initDAO();

    /**
     * Find an entity by your unique identifier (primary key).
     * 
     * @param primaryKey
     *            unique identifier by entity.
     * @throws ServiceException
     *             if the primary key is null.
     * 
     * @see lham.confrontosgremio.infra.AbstractDAO#findById(Object)
     * 
     */
    public E findById(final K primaryKey) {
        if (primaryKey == null) {
            throw new ServiceException(MessageBundleUtil.getMessage("abstract.exception.enter.primaryKey"));
        }

        return dao.findById(primaryKey);
    }

    /**
     * @see lham.confrontosgremio.infra.AbstractDAO#insert(AbstractModel)
     */
    public E insert(final E entity) {
        return dao.insert(entity);
    }

    /**
     * Sets DAO object.
     * 
     * @param dao DAO object.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setDAO(final AbstractDAO dao) {
        this.dao = dao;
    }

}
