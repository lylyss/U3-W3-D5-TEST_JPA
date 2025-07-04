package lobodanicolae.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lobodanicolae.entities.utente;

import java.util.List;

public class utenteDAO {
    // EntityManager per la gestione delle operazioni sul database
    private EntityManager entityManager;

    // Costruttore che riceve l'EntityManager
    public utenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Salva un nuovo utente nel database
    public void salvaUtente(utente utente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();
    }

    // Trova un utente tramite id
    public utente trovaUtentePerId(int id) {
        return entityManager.find(utente.class, id);
    }

    // Restituisce tutti gli utenti presenti nel database
    public List<utente> trovaTuttiUtenti() {
        TypedQuery<utente> query = entityManager.createNamedQuery("utente.findAll", utente.class);
        return query.getResultList();
    }

    // Aggiorna i dati di un utente esistente
    public void aggiornaUtente(utente utente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(utente);
        transaction.commit();
    }

    // Elimina un utente dal database
    public void eliminaUtente(utente utente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(utente) ? utente : entityManager.merge(utente));
        transaction.commit();
    }
}
