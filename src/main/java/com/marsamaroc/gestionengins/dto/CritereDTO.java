package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Critere;
import com.marsamaroc.gestionengins.entity.Engin;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CritereDTO {

    private  Long idCritere;
    private String critere;
    
    public CritereDTO(Critere critereDTO){
        this.idCritere = critereDTO.getIdCritere();
        this.critere = critereDTO.getNomCritere();

    }
}
