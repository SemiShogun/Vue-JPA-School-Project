package jl.corona.repository;


import jl.corona.entity.Infected;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class InfectedRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("corona");
        em = emFactory.createEntityManager();
    }

    public InfectedRepository() {
        setup();
    }

    public void close() {
        if ((em != null) && em.isOpen()) {
            em.close();
        }
        if ((emFactory != null) && emFactory.isOpen()) {
            emFactory.close();
        }
    }

    public List<Infected> getAllInfected() {
        List<Infected> listInfected = null;
        try {
            em.getTransaction().begin();
            listInfected = em.createNamedQuery("Infected.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listInfected;
    }

    public void createInfected(Infected inf) {
        try {
            em.getTransaction().begin();
            em.persist(inf);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Infected readInfected(int id) {
        Infected infected = null;
        try {
            em.getTransaction().begin();
            infected = em.find(Infected.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return infected;
    }

    public void updateInfected(Infected inf) {
        try {
            em.getTransaction().begin();
            Infected infected = em.find(Infected.class, inf.getId());
            if (infected != null) {
                em.merge(infected);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteInfected(int id) {
        try {
            em.getTransaction().begin();
            Infected infected = em.find(Infected.class, id);
            if (infected != null) {
                em.remove(infected);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
