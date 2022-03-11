package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Critere;
import com.marsamaroc.gestionengins.entity.DetailsPagne;
import com.marsamaroc.gestionengins.entity.Pagne;
import lombok.Data;

import javax.persistence.*;

@Data
public class DetailsPagneDTO {
    private Long id;

    private String typePagne;

    private String observation;

    private String statut;

    private CritereDTO critere;

    public DetailsPagneDTO(DetailsPagne detailsPagne) {
        this.id = detailsPagne.getId();
        this.typePagne = detailsPagne.getTypePagne();
        this.observation = detailsPagne.getObservation();
        this.statut = detailsPagne.getStatut();
        this.critere = new CritereDTO(detailsPagne.getCritere());
    }
}
