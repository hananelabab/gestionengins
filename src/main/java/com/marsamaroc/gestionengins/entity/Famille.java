package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Famille implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idFamille;
    String nomFamille;
    String icon;

    @OneToMany(mappedBy="famille")
    List<Engin> engin;

}
