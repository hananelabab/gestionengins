package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.EnginAffecte;
import com.marsamaroc.gestionengins.repository.ControleRepository;
import com.marsamaroc.gestionengins.repository.EnginAffecteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnginAffecteServiceImp implements EnginAffecteService {
    @Autowired
    EnginAffecteRepository enginAffecteRepository;
    @Autowired
    ControleRepository contoleRepository;
    @Override
    public EnginAffecte saveEnginDemande(EnginAffecte enginAffecte) {
        EnginAffecte oldEnginAffect =  getByEnginAndDemande(enginAffecte.getEngin(),enginAffecte.getDemande());
        enginAffecte.setIdDemandeEngin(oldEnginAffect==null ? null : oldEnginAffect.getIdDemandeEngin());
        return enginAffecteRepository.save(enginAffecte);
    }

    @Override
    public List<EnginAffecte> getAllAffectationByIdEngin(String id) {
        return enginAffecteRepository.findAllByEngin_CodeEngin(id);
    }

    @Override
    public EnginAffecte getById(Long id) {
        return enginAffecteRepository.getById(id);
    }

    @Override
    public EnginAffecte getByEnginAndDemande(Engin engin, Demande demande) {
        return enginAffecteRepository.findByEnginCodeEnginAndDemandeNumBCI(engin.getCodeEngin(),demande.getNumBCI());
    }

    @Override
    public void delete(EnginAffecte enginAffecte) {
        contoleRepository.deleteByEnginAffecteIdDemandeEngin(enginAffecte.getIdDemandeEngin());
        enginAffecteRepository.delete(enginAffecte);
    }
}
