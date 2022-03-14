package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.DetailsPanne;
import lombok.Data;

@Data
public class DetailsPagneDTO {
    private Long id;

    private String typePagne;

    private String observation;

    private String statut;

    private CritereDTO critere;

    public DetailsPagneDTO(DetailsPanne detailsPanne) {
        this.id = detailsPanne.getId();
        this.typePagne = detailsPanne.getTypePagne();
        this.observation = detailsPanne.getObservation();
        this.statut = detailsPanne.getStatut();
        this.critere = new CritereDTO(detailsPanne.getCritere());
    }
}
