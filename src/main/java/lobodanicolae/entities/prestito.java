package lobodanicolae.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private utente utente;

    private int elemento_prestito;
    private LocalDate data_prestito;
    private LocalDate data_restituzione;
    private LocalDate data_rest_effettivo;
    private int numero_tessera;

    // Costruttore vuoto
    public prestito() {
    }

    // Costruttore completo
    public prestito(int id, utente utente, int elemento_prestito, LocalDate data_prestito, LocalDate data_restituzione, LocalDate data_rest_effettivo, int numero_tessera) {
        this.id = id;
        this.utente = utente;
        this.elemento_prestito = elemento_prestito;
        this.data_prestito = data_prestito;
        this.data_restituzione = data_restituzione;
        this.data_rest_effettivo = data_rest_effettivo;
        this.numero_tessera = numero_tessera;
    }

    /* Getters */

    public int getId() {
        return id;
    }

    public utente getUtente() {
        return utente;
    }

    public void setUtente(utente utente) {
        this.utente = utente;
    }

    public int getElemento_prestito() {
        return elemento_prestito;
    }

    public void setElemento_prestito(int elemento_prestito) {
        this.elemento_prestito = elemento_prestito;
    }

    public LocalDate getData_prestito() {
        return data_prestito;
    }

    public void setData_prestito(LocalDate data_prestito) {
        this.data_prestito = data_prestito;
    }
    /* Setters */

    public LocalDate getData_restituzione() {
        return data_restituzione;
    }

    public void setData_restituzione(LocalDate data_restituzione) {
        this.data_restituzione = data_restituzione;
    }

    public LocalDate getData_rest_effettivo() {
        return data_rest_effettivo;
    }

    public void setData_rest_effettivo(LocalDate data_rest_effettivo) {
        this.data_rest_effettivo = data_rest_effettivo;
    }

    public int getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(int numero_tessera) {
        this.numero_tessera = numero_tessera;
    }
}
