package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Famille;
import lombok.Data;

import java.util.Date;

@Data
public class FamilleDTO {
    Long id;
    String nomFamille;
    Date dateDerniereAffectation;

    public FamilleDTO(Famille famille,Date dateDerniereAffectation){
        this.id = famille.getIdFamille();
        this.nomFamille = famille.getNomFamille();
        this.dateDerniereAffectation = dateDerniereAffectation;
    }
}
