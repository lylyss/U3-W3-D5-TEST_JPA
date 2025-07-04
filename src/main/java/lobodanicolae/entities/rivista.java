package lobodanicolae.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lobodanicolae.enums.periodicita;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class rivista extends catalogo {
    private int id_isbn;
    private periodicita periodicita;

    // Costruttore vuoto
    public rivista() {
    }

    // Costruttore completo
    public rivista(int id, String titolo, int anno_pubblicazione, int numero_pagine, int id_isbn, lobodanicolae.enums.periodicita periodicita) {
        super(id, titolo, anno_pubblicazione, numero_pagine);
        this.id_isbn = id_isbn;
        this.periodicita = periodicita;
    }

    // Costruttore senza id
    public rivista(String titolo, int anno_pubblicazione, int numero_pagine, int id_isbn, periodicita periodicita) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.id_isbn = id_isbn;
        this.periodicita = periodicita;
    }

    public int getId_isbn() {
        return id_isbn;
    }


    public periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
