package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class EnginAffecte implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idDemandeEngin;

    @ManyToOne
    @JoinColumn(name = "id_demande")
    Demande demande;
    @OneToMany(mappedBy = "enginAffecte")
    List<Controle> controleEngin;
    char etat;
    @ManyToOne
    @JoinColumn(name = "id_engin")
    Engin engin;
    Date dateEntree;
    Date dateSortie;
    Date dateAffectation;

    @ManyToOne
    @JoinColumn(name = "affectation_responsable")
    private User responsableAffectation;

    @ManyToOne
    @JoinColumn(name = "conducteur")
    private User conducteur;

}
