package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.Pagne;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PagneDTO {
    private Long id;
    private String typePagne ;
    private String observation;
    private String etat = "";
    private EnginDTO engin;
    private DemandeDTO derniereDemande;
    private DemandeDTO currentDemande;
    public PagneDTO(Pagne pagne){

        this.typePagne = pagne.getTypePagne();
        this.id = pagne.getId();
        this.derniereDemande = new DemandeDTO(pagne.getDerniereDemande()) ;
        this.currentDemande = new DemandeDTO(pagne.getCurrentDemande());
        this.engin = new EnginDTO(pagne.getEngin(), pagne.getEngin().getDerniereAffectation());
        this.etat = pagne.getEtat();
        this.observation = pagne.getObservation();

    }
}
