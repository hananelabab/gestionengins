package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Engin;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EnginSEDTO {

    private String codeEngin;
    private String typeEngin;
    private String capacite;
    private Long compteur;
    private String famille;
    private Date dateDernierAffectation;
    private String etat;
    public EnginSEDTO(Engin engin, Date dateDernierAffectation,String etat ){
        this.codeEngin = engin.getCodeEngin();
        this.typeEngin = engin.getTypeEngin() ;
        this.capacite = engin.getCapacite();
        this.compteur = engin.getCompteur();
        this.famille = engin.getFamille().getNomFamille();
        this.dateDernierAffectation = dateDernierAffectation;
        this.etat = etat;
    }
}
