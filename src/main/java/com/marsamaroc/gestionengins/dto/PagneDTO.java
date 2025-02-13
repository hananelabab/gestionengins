package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.DetailsPanne;
import com.marsamaroc.gestionengins.entity.Pagne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagneDTO {
    private Long id;
    private EnginDTO engin;
    private EnginAffecteeDTO derniereAffectation;
    private DemandeDTO currentDemande;
    private List<DetailsPagneDTO> detailsPagneList = new ArrayList<>();

    public PagneDTO(Pagne panne){
        this.id = panne.getId();
        this.derniereAffectation = new EnginAffecteeDTO(panne.getDernierAffectation()) ;
        this.currentDemande = new DemandeDTO(panne.getCurrentDemande());
        this.engin = new EnginDTO(panne.getEngin(), panne.getEngin().getDerniereAffectation());
        for(DetailsPanne detailsPanne : panne.getDetailsPanneList())
            detailsPagneList.add(new DetailsPagneDTO(detailsPanne));
    }
}
