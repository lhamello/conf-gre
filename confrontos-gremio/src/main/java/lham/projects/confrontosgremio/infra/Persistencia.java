package lham.projects.confrontosgremio.infra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import com.mysema.query.jpa.impl.JPAQuery;

public class Persistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public CriteriaBuilder criarCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }
    
    public JPAQuery criarJpaQuery() {
        return new JPAQuery(entityManager);
    }

    public Object atualizar(Object object) {
        entityManager.merge(object);
        entityManager.flush();

        return object;
    }

    public Object inserir(Object object) {
        entityManager.persist(object);
        entityManager.flush();

        return object;
    }
}
