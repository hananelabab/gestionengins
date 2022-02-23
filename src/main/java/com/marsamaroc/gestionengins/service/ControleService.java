package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Controle;

public interface ControleService {
    Controle getById(Long id);
    void save(Controle controle);
    Controle getControlByIdCritereAndIdAffectation(Long idCritere , Long idAffectation);
}
