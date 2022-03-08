package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.EnginDTO;
import com.marsamaroc.gestionengins.dto.EnginSEDTO;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.Famille;
import com.marsamaroc.gestionengins.service.ControleService;
import com.marsamaroc.gestionengins.service.EnginService;
import com.marsamaroc.gestionengins.service.FamilleService;
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
    @Autowired
    FamilleService familleService;

    @PostMapping(value = "/addEngins")
    List<Engin> addEnginList(@RequestBody List<Engin> enginList){
        Famille famille_Old;
        for(Engin engin : enginList){
            famille_Old = familleService.getFamilleByName(engin.getFamille().getNomFamille());
            if(famille_Old == null)
                famille_Old = familleService.saveFamille(engin.getFamille());
            engin.setFamille(famille_Old);
            engin.getFamille().setEngin(null);
            enginService.save(engin);
        }
        return enginList;
    }
    
    
    @GetMapping(value="/listeEngins")
    List<EnginDTO> listeEngins(){
        List<Engin> enginList = enginService.getAll();
        List<EnginDTO> enginDTOList =new ArrayList<>();
        for (Engin engin : enginList)
        	enginDTOList.add(new EnginDTO(engin, engin.getDerniereAffectation()));
        return enginDTOList;
    }
    
    @GetMapping(value="/listeEnginsSortie")
    List<EnginSEDTO> listeEnginsSortie(){
        List<Engin> enginList = enginService.getEnginsSorties();
        List<EnginSEDTO> enginSEDTOList =new ArrayList<>();
        for (Engin engin : enginList){
            enginSEDTOList.add(new EnginSEDTO(engin));
        }

        return enginSEDTOList;
    }
    @GetMapping(value="/listeEnginsEntree")
    List<EnginSEDTO> listeEnginsEntree(){
        List<Engin> enginList = enginService.getEnginsEntrees();
        List<EnginSEDTO> enginSEDTOList =new ArrayList<>();
        for (Engin engin : enginList)
            enginSEDTOList.add(new EnginSEDTO(engin));
        return enginSEDTOList;
    }
    @GetMapping(value="/listeEnginsDisponible/{famille}")
    List<EnginDTO> listeEnginsEntreeByFamille(@PathVariable("famille") Long famille){
        List<Engin> enginList = enginService.getEnginsEntreesByFamille(famille);
        List<EnginDTO> enginDTOList =new ArrayList<>();
        for (Engin engin : enginList)
        	enginDTOList.add(new EnginDTO(engin, engin.getDerniereAffectation()));
        return enginDTOList;
    }

    @GetMapping(value="/{idEngin}")
    EnginDTO getEngin(@PathVariable("idEngin") String idEngin){
        Engin engin = enginService.getById(idEngin);
        EnginDTO enginDTO = new EnginDTO(engin, engin.getDerniereAffectation());
        return enginDTO;
    }



}
