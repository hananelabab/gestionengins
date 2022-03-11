package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.PagneDTO;
import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.EnginAffecte;
import com.marsamaroc.gestionengins.entity.Pagne;
import com.marsamaroc.gestionengins.enums.EtatEngin;
import com.marsamaroc.gestionengins.service.DemandeService;
import com.marsamaroc.gestionengins.service.EnginService;
import com.marsamaroc.gestionengins.service.PagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pagnes")
public class PagneController {
    @Autowired
    PagneService pagneService;

    @Autowired
    EnginService enginService;
    @Autowired
    DemandeService demandeService;

    @PostMapping(value = "/addPagne")
    PagneDTO addPAgne(@RequestBody  Pagne pagne){
        Engin engin = enginService.getById(pagne.getEngin().getCodeEngin());
        engin.setEtat(EtatEngin.enpagne);
        enginService.update(engin);
        pagne.setCurrentDemande(demandeService.getById(pagne.getCurrentDemande().getNumBCI()));
        pagne.setDernierAffectation(enginService.getById(pagne.getEngin().getCodeEngin()).getDerniereAffectation());
        pagne.setEngin(engin);
        return new PagneDTO(pagneService.saveOrUpdatePagne(pagne));
    }


}
