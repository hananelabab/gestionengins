package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.DetailsPagne;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.Pagne;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Data
public class PagneDTO {
    private Long id;
    private EnginDTO engin;
    private EnginAffecteeDTO derniereAffectation;
    private DemandeDTO currentDemande;
    private List<DetailsPagneDTO> detailsPagneList = new ArrayList<>();

    public PagneDTO(Pagne pagne){
        this.id = pagne.getId();
        this.derniereAffectation = new EnginAffecteeDTO(pagne.getDernierAffectation()) ;
        this.currentDemande = new DemandeDTO(pagne.getCurrentDemande());
        this.engin = new EnginDTO(pagne.getEngin(), pagne.getEngin().getDerniereAffectation());
        for(DetailsPagne detailsPagne : pagne.getDetailsPagneList())
            detailsPagneList.add(new DetailsPagneDTO(detailsPagne));
    }
}
