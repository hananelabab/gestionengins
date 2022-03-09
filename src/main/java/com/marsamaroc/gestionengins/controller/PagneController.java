package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.PagneDTO;
import com.marsamaroc.gestionengins.entity.Pagne;
import com.marsamaroc.gestionengins.service.PagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pagnes")
public class PagneController {
    @Autowired
    PagneService pagneService;

    @PostMapping(value = "/addPagne")
    PagneDTO addPAgne(Pagne pagne){
        return new PagneDTO(pagneService.saveOrUpdatePagne(pagne));
    }


}
