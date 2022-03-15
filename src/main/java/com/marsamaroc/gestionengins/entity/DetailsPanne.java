package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
<<<<<<< HEAD:src/main/java/com/marsamaroc/gestionengins/entity/DetailsPagne.java
@Entity
public class DetailsPagne implements Serializable{
=======
public class DetailsPanne implements Serializable{
>>>>>>> 2e63a0fa4b0a09187e727bbb3b0f4adba03a7cb3:src/main/java/com/marsamaroc/gestionengins/entity/DetailsPanne.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typePagne;

    private String observation;

    private String statut="NF";

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;

    @ManyToOne
    @JoinColumn(name = "critere_id_critere")
    private Critere critere;


}
