package tasks.crudServices;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tasks.entities.Planet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class PlanetCrudService {

    private final EntityManager entityManager;

    public PlanetCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveOrUpdate(Planet planet) {
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(planet);
        transaction.commit();
    }

    public Planet findById(String id) {
        return entityManager.find(Planet.class, id);
    }

    public List<Planet> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Planet p");
        return query.getResultList();
    }

    public void delete(String id) {
        Planet planet = findById(id);
        if (planet != null) {
            Session session = entityManager.unwrap(Session.class);
            Transaction transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        }
    }

    public void deletePlanet(String id) {
        Planet planet = findById(id);
        if (planet != null) {
            Session session = entityManager.unwrap(Session.class);
            Transaction transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        }
    }
}