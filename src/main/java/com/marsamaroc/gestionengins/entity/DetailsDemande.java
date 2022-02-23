package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DetailsDemande {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @ManyToOne
    Demande demande;
    @ManyToOne
    Famille famille;
    int quantite;
}
