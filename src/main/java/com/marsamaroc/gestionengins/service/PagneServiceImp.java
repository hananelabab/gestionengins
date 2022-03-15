package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Panne;
import com.marsamaroc.gestionengins.repository.PagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagneServiceImp implements PagneService{
    @Autowired
    PagneRepository pagneRepository;
    @Override
    public Panne saveOrUpdatePagne(Panne panne) {
        return pagneRepository.save(panne);
    }
}
