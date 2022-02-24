package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.CritereDTO;
import com.marsamaroc.gestionengins.dto.EnginDTO;
import com.marsamaroc.gestionengins.dto.EnginSEDTO;
import com.marsamaroc.gestionengins.entity.Controle;
import com.marsamaroc.gestionengins.entity.Critere;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.service.ControleService;
import com.marsamaroc.gestionengins.service.CritereService;
import com.marsamaroc.gestionengins.service.EnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/criteres")
public class CriteresController {
	
    @Autowired
    CritereService critereService;
  
    
    
    @GetMapping(value="/listeCriteres")
    List<CritereDTO> listeCriteres() throws ParseException{
        List<Critere> listCriteres = critereService.findAllCriteres();

        List<CritereDTO> listCritereDTOs =new ArrayList<>();
        for (Critere critere : listCriteres)
        	listCritereDTOs.add(new CritereDTO(critere));
        return listCritereDTOs;
    }




}
