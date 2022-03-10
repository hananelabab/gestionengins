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



    public void sync(Controle controle){
        this.id = controle.id != null ? controle.id : this.id;
        this.enginAffecte =  controle.enginAffecte != null ? controle.enginAffecte : this.enginAffecte;
        this.critere =  controle.critere != null ? controle.critere : this.critere;
        this.etatSortie =  controle.etatSortie != 0 ? controle.etatSortie : this.etatSortie;
        this.etatEntree =  controle.etatEntree != 0 ? controle.etatEntree : this.etatEntree;
        this.obsEntree =  controle.obsEntree != null ? controle.obsEntree : this.obsEntree;
        this.obsSortie =  controle.obsSortie != null ? controle.obsSortie : this.obsSortie;
    }
}
