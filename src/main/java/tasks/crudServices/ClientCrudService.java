package tasks.crudServices;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tasks.entities.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ClientCrudService {

    private final EntityManager entityManager;

    public ClientCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveOrUpdate(Client client) {
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(client);
        transaction.commit();
    }

    public Client findById(Long id) {
        return entityManager.find(Client.class, id);
    }

    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Client c");
        return query.getResultList();
    }

    public void delete(Long id) {
        Client client = findById(id);
        if (client != null) {
            Session session = entityManager.unwrap(Session.class);
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
}