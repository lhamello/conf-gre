package lham.projects.confrontosgremio.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lham.projects.confrontosgremio.infra.Persistencia;

public class ConectorBaseDados {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    
    public static Persistencia iniciarConexao() {
        if (!isConexaoAberta()) {
            criarConexao();
        }
        
        Persistencia persistencia = new Persistencia();
        persistencia.setEntityManager(entityManager);
        
        return persistencia;
    }
    
    public static void encerrarConexao() {
        if (isConexaoAberta()) {
            
            if (!entityManager.getTransaction().getRollbackOnly()) {
                commit();
            } else {
                rollback();
            }
        }
    }
    
    private static boolean isConexaoAberta() {
        return entityManager != null && entityManager.isOpen();
    }
    
    private static void criarConexao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("CONFRONTOS_GREMIO_TEST");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }
    
    private static void commit() {
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
    
    private static void rollback() {
        entityManager.getTransaction().rollback();
        entityManagerFactory.close();
    }
}
