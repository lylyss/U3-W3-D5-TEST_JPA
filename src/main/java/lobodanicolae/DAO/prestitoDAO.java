package lobodanicolae.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lobodanicolae.entities.prestito;

import java.util.List;

public class prestitoDAO {

    private EntityManager entityManager;

    // Costruttore che riceve l'EntityManager
    public prestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Salva un nuovo prestito
    public void salvaPrestito(prestito prestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prestito);
        transaction.commit();
    }

    // Trova un prestito tramite id
    public prestito trovaPrestitoPerId(int id) {
        return entityManager.find(prestito.class, id);
    }

    // Restituisce tutti i prestiti
    public List<prestito> trovaTuttiPrestiti() {
        TypedQuery<prestito> query = entityManager.createQuery("SELECT p FROM prestito p", prestito.class);
        return query.getResultList();
    }

    // Aggiorna un prestito
    public void aggiornaPrestito(prestito prestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(prestito);
        transaction.commit();
    }

    // Elimina un prestito
    public void eliminaPrestito(prestito prestito) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(entityManager.contains(prestito) ? prestito : entityManager.merge(prestito));
        transaction.commit();
    }
}
