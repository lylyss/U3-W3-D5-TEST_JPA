package lobodanicolae.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lobodanicolae.entities.catalogo;

import java.util.List;

public class catalogoDAO {

    private EntityManager entityManager;


    public catalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Salva un nuovo elemento del catalogo
    public void salvaCatalogo(catalogo catalogo) {

        // Inizia una transazione per salvare un nuovo catalogo
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizia la transazione
        transaction.begin();

        // Persisti l'oggetto catalogo nel database
        entityManager.persist(catalogo);

        // Commit della transazione per salvare le modifiche nel database
        transaction.commit();
    }

    // Trova un elemento del catalogo tramite id
    public catalogo trovaCatalogoPerId(int id) {
        return entityManager.find(catalogo.class, id);
    }

    // Restituisce tutti gli elementi del catalogo
    public List<catalogo> trovaTuttiCataloghi() {
        TypedQuery<catalogo> query = entityManager.createNamedQuery("catalogo.findAll", catalogo.class);
        return query.getResultList();
    }

    // Aggiorna un elemento del catalogo
    public void aggiornaCatalogo(catalogo catalogo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(catalogo);
        transaction.commit();
    }

    // Elimina un elemento del catalogo
    public void eliminaCatalogo(catalogo catalogo) {

        // Inizia una nuova transazione per eliminare un catalogo
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizia la transazione
        transaction.begin();

        // Rimuove l'oggetto catalogo dal database
        entityManager.remove(entityManager.contains(catalogo) ? catalogo : entityManager.merge(catalogo));

        // Commit della transazione per salvare le modifiche nel database
        transaction.commit();
    }
}
