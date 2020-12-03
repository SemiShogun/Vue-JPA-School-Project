package jl.corona.repository;


import jl.corona.entity.Continent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ContinentRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("corona");
        em = emFactory.createEntityManager();
    }

    public ContinentRepository() {
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

    public List<Continent> getAllContinent() {
        List<Continent> listContinent = null;
        try {
            em.getTransaction().begin();
            listContinent = em.createNamedQuery("Continent.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listContinent;
    }

    public void createContinent(Continent inf) {
        try {
            em.getTransaction().begin();
            em.persist(inf);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Continent readContinent(long id) {
        Continent continent = null;
        try {
            em.getTransaction().begin();
            continent = em.find(Continent.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return continent;
    }

    public void updateContinent(Continent inf) {
        try {
            em.getTransaction().begin();
            Continent continent = em.find(Continent.class, inf.getId());
            if (continent != null) {
                em.merge(continent);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteContinent(long id) {
        try {
            em.getTransaction().begin();
            Continent continent = em.find(Continent.class, id);
            if (continent != null) {
                em.remove(continent);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

}
