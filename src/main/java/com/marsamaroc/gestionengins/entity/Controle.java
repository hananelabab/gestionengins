package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Controle implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_demand_engin")
    EnginAffecte enginAffecte;

    @ManyToOne
    @JoinColumn(name = "id_critere")
    private Critere critere;
    private  char etatSortie;
    private char etatEntree;
    private String obsEntree;
    private String obsSortie;
}
