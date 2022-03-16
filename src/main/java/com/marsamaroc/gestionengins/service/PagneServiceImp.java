package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Pagne;
import com.marsamaroc.gestionengins.repository.PagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagneServiceImp implements PagneService{
    @Autowired
    PagneRepository pagneRepository;
    @Override
    public Pagne saveOrUpdatePagne(Pagne panne) {
        return pagneRepository.save(panne);
    }
}
