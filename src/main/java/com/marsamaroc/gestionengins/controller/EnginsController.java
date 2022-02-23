package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.EnginDTO;
import com.marsamaroc.gestionengins.dto.EnginSEDTO;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.service.ControleService;
import com.marsamaroc.gestionengins.service.EnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/engin")
public class EnginsController {
    @Autowired
    EnginService enginService;
    @Autowired
    ControleService controleService;
    @GetMapping(value="/listeEnginsSortie")
    List<EnginSEDTO> listeEnginsSortie(){
        List<Engin> enginList = enginService.getEnginsSorties();

        List<EnginSEDTO> enginSEDTOList =new ArrayList<>();
        for (Engin engin : enginList)
            enginSEDTOList.add(new EnginSEDTO(engin , engin.getDerniereAffectation().getDateSortie() , "Sortie" ));
        return enginSEDTOList;
    }
    @GetMapping(value="/listeEnginsEntree")
    List<EnginSEDTO> listeEnginsEntree(){
        List<Engin> enginList = enginService.getEnginsEntrees();
        List<EnginSEDTO> enginSEDTOList =new ArrayList<>();
        for (Engin engin : enginList)
            enginSEDTOList.add(new EnginSEDTO(engin , engin.getDerniereAffectation().getDateSortie() , "Entrée" ));
        return enginSEDTOList;
    }
    @GetMapping(value="/{idEngin}")
    EnginDTO ElisteEnginsEntree(@PathVariable("idEngin") String idEngin){
        Engin engin = enginService.getById(idEngin);
        EnginDTO enginDTO = new EnginDTO(engin, engin.getDerniereAffectation());
        return enginDTO;
    }



}
