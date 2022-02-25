package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.EnginAffecte;
import com.marsamaroc.gestionengins.repository.EnginAffecteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnginAffecteServiceImp implements EnginAffecteService {
    @Autowired
    EnginAffecteRepository enginAffecteRepository;
    @Override
    public EnginAffecte saveEnginDemande(EnginAffecte enginAffecte) {
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
    public void delete(EnginAffecte enginAffecte) {
        enginAffecteRepository.delete(enginAffecte);
    }
}
