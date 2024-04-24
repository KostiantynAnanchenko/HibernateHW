package Tasks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import Tasks.entities.Client;
import Tasks.entities.Planet;
import Tasks.crudServices.PlanetCrudService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();


        Session session = sessionFactory.openSession();


        Transaction transaction = session.beginTransaction();
        Client newClient = new Client();
        newClient.setName("John Doe");
        session.save(newClient);
        transaction.commit();
        System.out.println("Added client with ID: " + newClient.getId());

        Transaction transaction2 = session.beginTransaction();
        Client newClient2 = new Client();
        newClient2.setName("Examle Examplenko");
        session.save(newClient2);
        transaction2.commit();
        System.out.println("Added client with ID: " + newClient2.getId());


        Long clientId = newClient.getId();
        Client foundClient = session.get(Client.class, clientId);
        System.out.println("Found client by ID: " + foundClient.getName());


        transaction = session.beginTransaction();
        foundClient.setName("Jane Smith");
        session.update(foundClient);
        transaction.commit();
        System.out.println("Updated client name: " + foundClient.getName());


        transaction = session.beginTransaction();
        session.delete(foundClient);
        transaction.commit();
        System.out.println("Client deleted");


        List<Client> allClients = session.createQuery("FROM Client", Client.class).list();
        System.out.println("All clients:");
        for (Client client : allClients) {
            System.out.println(client.getName());
        }

        PlanetCrudService planetCrudService = new PlanetCrudService(sessionFactory.createEntityManager());


        Planet newPlanet = new Planet();
        newPlanet.setId("TATU");
        newPlanet.setName("Tatuin");
        planetCrudService.saveOrUpdate(newPlanet);
        System.out.println("Added planet with ID: " + newPlanet.getId());

        Planet newPlanet2 = new Planet();
        newPlanet2.setId("ARA");
        newPlanet2.setName("Arakis");
        planetCrudService.saveOrUpdate(newPlanet2);
        System.out.println("Added planet with ID: " + newPlanet2.getId());


        Planet foundPlanet = planetCrudService.findById("TATU");
        System.out.println("Found planet by ID: " + foundPlanet.getName());


        foundPlanet.setName("Venus");
        planetCrudService.saveOrUpdate(foundPlanet);
        System.out.println("Updated planet name: " + foundPlanet.getName());


        planetCrudService.delete("TATU");
        System.out.println("Planet deleted");


        List<Planet> allPlanets = planetCrudService.findAll();
        System.out.println("All planets:");
        for (Planet planet : allPlanets) {
            System.out.println("Planet ID: " + planet.getId() + ", Name: " + planet.getName());
        }

        session.close();
        sessionFactory.close();
    }
}