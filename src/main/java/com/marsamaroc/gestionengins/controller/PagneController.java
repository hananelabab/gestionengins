package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.PagneDTO;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.Panne;
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
    PagneDTO addPAgne(@RequestBody Panne panne){
        Engin engin = enginService.getById(panne.getEngin().getCodeEngin());
        engin.setEtat(EtatEngin.enpagne);
        enginService.update(engin);
        panne.setCurrentDemande(demandeService.getById(panne.getCurrentDemande().getNumBCI()));
        panne.setDernierAffectation(enginService.getById(panne.getEngin().getCodeEngin()).getDerniereAffectation());
        panne.setEngin(engin);
        return new PagneDTO(pagneService.saveOrUpdatePagne(panne));
    }


}
