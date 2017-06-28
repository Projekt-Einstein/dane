import persistence.Address;
import persistence.Contact;
import persistence.Meeting;
import persistence.Place;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dominik Ciborowski
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");

        EntityManager entityManager = emf.createEntityManager();

        prepareData(entityManager);

        for (Contact c : getAllContacts(entityManager)) {
            System.out.println(c);
        }

        System.out.println(getContactByEmail(entityManager, "email 3"));

        System.out.println(getAllMeetings(entityManager));

        entityManager.close();
        emf.close();
    }

    private static List<Contact> getAllContacts(EntityManager entityManager) {
        Query query = entityManager.createQuery("select c from Contact c", Contact.class);

        return query.getResultList();
    }

    private static Contact getContactByEmail(EntityManager entityManager, String email) {
        TypedQuery<Contact> query =
                entityManager.createQuery("select c from Contact c where c.email = :email", Contact.class);
        query.setParameter("email", email);

        return query.getSingleResult();
    }

    private static List<Meeting> getAllMeetings(EntityManager entityManager) {
        Query query = entityManager.createQuery("select m from Meeting m", Meeting.class);

        return query.getResultList();
    }

    private static void prepareData(EntityManager entityManager) {
        Contact[] contacts = new Contact[10];
        Address[] addresses = new Address[5];
        Place[] places = new Place[5];
        Meeting[] meetings = new Meeting[10];

        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = new Contact("Contact " + i, "Surname " + i, "phone " + i, "email " + i);
        }

        for (int i = 0; i < addresses.length; i++) {
            addresses[i] = new Address("Street " + i, i, i, "code " + i, "City " + i, "Country " + i);
        }

        for (int i = 0; i < places.length; i++) {
            places[i] = new Place("Place " + i, addresses[i]);
        }

        for (int i = 0; i < meetings.length; i++) {
            meetings[i] = new Meeting(LocalDateTime.now(), "info " + i);

            meetings[i].setMeetingPlace(places[i / 2]);
        }

        List<Contact> contacts1 = Arrays.asList(contacts[0], contacts[2], contacts[5]);
        List<Contact> contacts2 = Arrays.asList(contacts[6], contacts[4], contacts[1], contacts[2]);
        List<Contact> contacts3 = Arrays.asList(contacts[6], contacts[4], contacts[8]);

        meetings[2].setContacts(contacts1);
        meetings[4].setContacts(contacts2);
        meetings[5].setContacts(contacts3);

        entityManager.getTransaction().begin();

        for (Contact c : contacts) {
            entityManager.persist(c);
        }

        for (Place p : places) {
            entityManager.persist(p);
        }

        for (Meeting m : meetings) {
            entityManager.persist(m);
        }

        entityManager.getTransaction().commit();
    }
}
