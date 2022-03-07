package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Pagne implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String typePagne ;

    private String observation;

    private String etat = "";

    @ManyToOne
    @JoinColumn(name = "engin_code_engin")
    private Engin engin;

    @ManyToOne
    @JoinColumn(name = "derniere_demande_num_bci")
    private Demande derniereDemande;

    @ManyToOne
    @JoinColumn(name = "current_demande_num_bci")
    private Demande currentDemande;




}
