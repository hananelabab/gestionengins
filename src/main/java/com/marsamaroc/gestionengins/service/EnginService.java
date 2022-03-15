package com.marsamaroc.gestionengins.service;



import com.marsamaroc.gestionengins.dto.EnginDTO;
import com.marsamaroc.gestionengins.entity.Engin;

import java.util.List;

public interface EnginService {
    Engin getById(String id);

    List<Engin> getAll();
    List<Engin> getEnginsSorties();
    List<Engin> getEnginsEntrees();
    List<Engin> getEnginsEntreesByFamille(Long Famille);

    void save(Engin engin);

    EnginDTO saveOrUpdate(Engin engin);

    Engin update(Engin engin);
}
