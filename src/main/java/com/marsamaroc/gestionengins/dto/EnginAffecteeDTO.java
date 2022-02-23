package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.EnginAffecte;
import lombok.Data;

@Data
public class EnginAffecteeDTO {
    private Long idEnginAffect;
    private String codeEngin ;
    private Long numBCI;

    public EnginAffecteeDTO(EnginAffecte enginAffecte){
        idEnginAffect = enginAffecte.getIdDemandeEngin();
        codeEngin = enginAffecte.getEngin().getCodeEngin();
        numBCI = enginAffecte.getDemande().getNumBCI();
    }

}
