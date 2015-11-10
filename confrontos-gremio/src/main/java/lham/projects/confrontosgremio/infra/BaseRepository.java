package lham.projects.confrontosgremio.infra;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

public class BaseRepository {

    @PersistenceContext
    protected EntityManager entityManager;
    protected JPAQuery jpaQuery;

    @PostConstruct
    private void init() {
        this.jpaQuery = new JPAQuery(entityManager);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQuery = new JPAQuery(entityManager);
    }
}
