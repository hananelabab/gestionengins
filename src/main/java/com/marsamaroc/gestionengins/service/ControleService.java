package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Controle;
import com.marsamaroc.gestionengins.entity.EnginAffecte;

public interface ControleService {
    Controle getById(Long id);
    void save(Controle controle, EnginAffecte enginAffecte);
    Controle getControlByIdCritereAndIdAffectation(Long idCritere , Long idAffectation);
}
