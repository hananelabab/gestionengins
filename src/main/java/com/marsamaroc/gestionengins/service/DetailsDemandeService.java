package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.DetailsDemande;

import java.util.List;

public interface DetailsDemandeService {
    void saveDetailDemandes(List<DetailsDemande> detailsDemande , Demande demande);
    DetailsDemande getDetailsDemandeByNumBciAndIdFammille(Long numBci , Long idFamille);

}
