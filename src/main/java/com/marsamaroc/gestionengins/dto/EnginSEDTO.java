package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.enums.EtatAffectation;
import com.marsamaroc.gestionengins.enums.EtatEngin;
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
    private EtatAffectation etat;
    public EnginSEDTO(Engin engin, Date dateDernierAffectation, EtatAffectation etat ){
        this.codeEngin = engin.getCodeEngin();
        this.typeEngin = engin.getTypeEngin() ;
        this.capacite = engin.getCapacite();
        this.compteur = engin.getCompteur();
        this.famille = engin.getFamille().getNomFamille();
        this.dateDernierAffectation = dateDernierAffectation;
        this.etat = etat;
    }
}
