package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.EnginAffecte;

import java.util.List;

public interface EnginAffecteService {

    EnginAffecte saveEnginDemande(EnginAffecte enginAffecte);
    List<EnginAffecte> getAllAffectationByIdEngin(String id);
    EnginAffecte getById(Long id);

    EnginAffecte getByEnginAndDemande(Engin engin, Demande demande);
    void delete(EnginAffecte enginAffecte);
}
