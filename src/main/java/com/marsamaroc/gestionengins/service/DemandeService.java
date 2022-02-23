package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Demande;

import java.util.List;

public interface DemandeService {
    List<Demande> findAllDemande();
    Demande findAllDemandeComplet(Long id);
    Demande saveDamande(Demande demande);
    Demande getById(Long id);

}
