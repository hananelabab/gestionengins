package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Controle;
import com.marsamaroc.gestionengins.entity.EnginAffecte;
import com.marsamaroc.gestionengins.repository.ControleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleServiceImp implements ControleService{

    @Autowired
    ControleRepository controleRepository;
    @Override
    public Controle getById(Long id) {
        return controleRepository.getById(id);
    }

    @Override
    public void save(Controle controle, EnginAffecte enginAffecte) {
        controle.setEnginAffecte(enginAffecte);
        controleRepository.save(controle);
    }

    @Override
    public Controle getControlByIdCritereAndIdAffectation(Long idCritere, Long idAffectation) {

        return controleRepository.findAllByCritere_IdCritereAndEnginAffecte_IdDemandeEngin(idCritere,idAffectation);
    }
}
