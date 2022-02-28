package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.EnginDTO;
import com.marsamaroc.gestionengins.dto.EnginSEDTO;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.service.ControleService;
import com.marsamaroc.gestionengins.service.EnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/engin")
public class EnginsController {
    @Autowired
    EnginService enginService;
    @Autowired
    ControleService controleService;

    @PostMapping(value = "/addEngins")
    List<Engin> addEnginList(@RequestBody List<Engin> enginList){
        for(Engin engin : enginList){
            enginService.save(engin);
        }
        return enginList;

    }



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
    EnginDTO getEngin(@PathVariable("idEngin") String idEngin){
        Engin engin = enginService.getById(idEngin);
        EnginDTO enginDTO = new EnginDTO(engin, engin.getDerniereAffectation());
        return enginDTO;
    }



}
