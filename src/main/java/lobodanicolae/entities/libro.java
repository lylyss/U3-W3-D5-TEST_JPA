package lobodanicolae.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lobodanicolae.enums.autore;
import lobodanicolae.enums.genere;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class libro extends catalogo {
    private int id_isbn;
    private autore autore;
    private genere genere;

    public libro() {
    }

    public libro(int id, String titolo, int anno_pubblicazione, int numero_pagine, int id_isbn, autore autore, genere genere) {
        super(id, titolo, anno_pubblicazione, numero_pagine);
        this.id_isbn = id_isbn;
        this.autore = autore;
        this.genere = genere;
    }

    public int getId_isbn() {
        return id_isbn;
    }

    public autore getAutore() {
        return autore;
    }

    public void setAutore(autore autore) {
        this.autore = autore;
    }

    public genere getGenere() {
        return genere;
    }

    public void setGenere(genere genere) {
        this.genere = genere;
    }
}
