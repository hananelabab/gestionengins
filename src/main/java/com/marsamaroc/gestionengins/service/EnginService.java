package com.marsamaroc.gestionengins.service;



import com.marsamaroc.gestionengins.entity.Engin;

import java.util.List;

public interface EnginService {
    Engin getById(String id);

    List<Engin> getEnginsSorties();
    List<Engin> getEnginsEntrees();



}
