package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.DetailsDemande;

import java.util.List;

public interface DetailsDemandeService {
    DetailsDemande getDetailsDemandeByNumBciAndIdFammille(Long numBci , Long idFamille);

}
