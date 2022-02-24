package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Critere;

import java.util.List;

public interface CritereService {

    Critere getById(Long id);

    List<Critere> findAllCriteres();
}
