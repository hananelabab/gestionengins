package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Controle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_demand_engin")
    EnginAffecte enginAffecte;

    @ManyToOne
    @JoinColumn(name = "id_critere")
    Critere critere;
    char etatSortie;
    char etatEntree;
    String obsEntree;
    String obsSortie;
}
