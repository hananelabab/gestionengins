package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class DetailsDemande implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @ManyToOne
    Demande demande;
    @ManyToOne
    Famille famille;
    int quantite;
}
