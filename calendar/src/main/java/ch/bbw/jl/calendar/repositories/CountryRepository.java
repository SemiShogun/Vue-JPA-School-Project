package ch.bbw.jl.calendar.repositories;

import ch.bbw.jl.calendar.models.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CountryRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("calendar");
        em = emFactory.createEntityManager();
    }

    public CountryRepository() {
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

    public List<Country> getAllCountry() {
        List<Country> listCountry = null;
        try {
            em.getTransaction().begin();
            listCountry = em.createNamedQuery("Country.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listCountry;
    }

    public void createCountry(Country inf) {
        try {
            em.getTransaction().begin();
            em.persist(inf);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Country readCountry(int id) {
        Country country = null;
        try {
            em.getTransaction().begin();
            country = em.find(Country.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return country;
    }

    public void updateCountry(Country inf) {
        try {
            em.getTransaction().begin();
            Country country = em.find(Country.class, inf.getId());
            if (country != null) {
                em.merge(country);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteCountry(int id) {
        try {
            em.getTransaction().begin();
            Country country = em.find(Country.class, id);
            if (country != null) {
                em.remove(country);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
