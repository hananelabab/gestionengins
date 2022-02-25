package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EnginDTO {

    private String codeEngin;
    private String typeEngin;
    private String capacite;
    private Long compteur;
    private FamilleDTO famille;
    private Long idDemandeEngin;

    

    private List<CritereDemandeDTO> critere = new ArrayList<>();

    public EnginDTO(Engin engin, EnginAffecte enginAffecte){
        this.codeEngin = engin.getCodeEngin();
        this.typeEngin = engin.getTypeEngin();
        this.capacite = engin.getCapacite();
        this.compteur = engin.getCompteur();
        this.idDemandeEngin = enginAffecte.getIdDemandeEngin();

        Date dateDerniereAffectation=engin.getDerniereAffectation().getDateSortie() ;

        this.famille = new FamilleDTO(engin.getFamille(),dateDerniereAffectation);

        if(enginAffecte.getControleEngin() == null) enginAffecte.setControleEngin(new ArrayList<>()) ;
        for (Controle controle : enginAffecte.getControleEngin())
            this.critere.add(new CritereDemandeDTO(controle));
    }
}
