package lobodanicolae;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lobodanicolae.entities.libro;
import lobodanicolae.entities.utente;
import lobodanicolae.enums.autore;
import lobodanicolae.enums.genere;

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

        // Creazione libri
        libro l1 = new libro("Il Signore degli Anelli", 1954, 1200, 111111, autore.HERMAN_MELVILLE, genere.FANTASY);
        libro l2 = new libro("1984", 1949, 328, 222222, autore.JANE_AUSTEN, genere.SCIFI);
        libro l3 = new libro("Il Piccolo Principe", 1943, 96, 333333, autore.F_SCOTT_FITZGERALD, genere.ROMANCE);
        libro l4 = new libro("Orgoglio e Pregiudizio", 1813, 432, 444444, autore.SARAH_J_MAAS, genere.ROMANCE);
        libro l5 = new libro("Moby Dick", 1931, 635, 555555, autore.STEPHEN_KING, genere.FANTASY);

        // Salvataggio utenti e libri nel database
        em.getTransaction().begin();


     /*    em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.persist(u4);

        em.persist(l1);
        em.persist(l2);
        em.persist(l3);
        em.persist(l4);
        em.persist(l5);*/


        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Aggiunto  con successo!");
    }
}
