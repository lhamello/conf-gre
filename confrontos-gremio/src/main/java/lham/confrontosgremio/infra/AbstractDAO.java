package lham.confrontosgremio.infra;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class AbstractDAO<E extends AbstractModel<K>, K> {
    
    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<E> entity;

    /**
     * Constructor method.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        final ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entity = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    /**
     * Find an entity by your unique identifier (primary key).
     * 
     * @param primaryKey
     *            unique identifier by entity.
     * 
     * @return the searched entity from data base.
     */
    @SuppressWarnings("unchecked")
    public E findById(final K primaryKey) {
        final StringBuilder namedQuery = new StringBuilder(50);
        namedQuery.append(entity.getSimpleName()).append(".findById");

        final Query query = entityManager.createNamedQuery(namedQuery.toString());
        query.setParameter("id", primaryKey);

        return (E) query.getSingleResult();
    }

    /**
     * Insert entity on data base.
     * 
     * @param entity
     *            entity to be inserted.
     * 
     * @return the inserted entity.
     */
    public E insert(final E entity) {
        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }
    
    public E update(final E entity) {
        final E mergedEntity = entityManager.merge(entity);
        entityManager.flush();
        
        return mergedEntity;
    }
    
}
