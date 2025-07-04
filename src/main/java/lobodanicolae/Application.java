package lobodanicolae;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lobodanicolae.entities.utente;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        // Creazione della factory e dell'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("U3-W3-D5_TEST_JPA");
        EntityManager em = emf.createEntityManager();

        // Creazione utenti
        utente u1 = new utente("Mario", "Rossi", LocalDate.of(1990, 1, 1), 1001);
        utente u2 = new utente("Luca", "Bianchi", LocalDate.of(1985, 5, 15), 1002);
        utente u3 = new utente("Anna", "Verdi", LocalDate.of(1992, 8, 20), 1003);
        utente u4 = new utente("Sara", "Neri", LocalDate.of(1998, 12, 5), 1004);

        // Salvataggio utenti nel database
        
        em.getTransaction().begin();


        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.persist(u4);


        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Utenti inseriti con successo!");
    }
}
