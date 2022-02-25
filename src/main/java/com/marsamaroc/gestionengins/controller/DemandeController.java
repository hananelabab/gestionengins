package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.DemandeDTO;
import com.marsamaroc.gestionengins.dto.DemandeCompletDTO;
import com.marsamaroc.gestionengins.dto.EnginAffecteeDTO;
import com.marsamaroc.gestionengins.dto.EnginDTO;
import com.marsamaroc.gestionengins.entity.*;
import com.marsamaroc.gestionengins.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    DetailsDemandeService detailsDemandeService;
    @Autowired
    DemandeService demandeService;
    @Autowired
    FamilleService familleService;
    @Autowired
    PostService postService;
    @Autowired
    EnginService enginService;
    @Autowired
    EnginAffecteService enginAffecteService;
    @Autowired
    ControleService controleService;
    @Autowired
    CritereService critereService;
    @Autowired
    UserService userService;
    @RequestMapping(value="/all",method= RequestMethod.GET)
    List<DemandeDTO> getAllDemande(){
        List<Demande> demandeList= demandeService.findAllDemande();
        List<DemandeDTO> demandeDTOList = new ArrayList<>();
        for(Demande demande : demandeList){
            demandeDTOList.add(new DemandeDTO(demande));
        }
        return demandeDTOList;
    }


    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    DemandeCompletDTO getAllDemande(@PathVariable("id") String id ){
        Demande demande = demandeService.getById(Long.parseLong(id));
        if(demande == null)
            return null;
        List<EnginDTO> enginDTOList = new ArrayList<>();
        for(EnginAffecte enginAffecte : demande.getEnginsAffecteList()){
            EnginDTO enginDTO= new EnginDTO(enginAffecte.getEngin()  , enginAffecte);
            enginDTOList.add(enginDTO);
            System.out.println(enginDTO.getFamille().getDateDerniereAffectation());
        }
        DemandeCompletDTO demandeCompletDTOList = new DemandeCompletDTO(
                demande,enginDTOList);
        return demandeCompletDTOList;
    }

    @PostMapping(value="/add")
    DemandeDTO addDemande(@RequestBody Demande demande) {
        demande = demandeService.saveDamande(demande);
        detailsDemandeService.saveDetailDemandes(demande.getDetailsDemandeList() , demande);
        return  new DemandeDTO(demande);
    }

    @PostMapping(value="/affecter")
    List<EnginAffecteeDTO> affecterEngins(@RequestBody List<EnginAffecte> enginAffecteList) {

        //Delete if is not exist
        List<EnginAffecte> enginAffecteListOld = demandeService.getById(enginAffecteList.get(0).getDemande().getNumBCI()).getEnginsAffecteList();
        for(EnginAffecte enginAffecte : enginAffecteListOld){
            if(!enginAffecteList.contains(enginAffecte))
                enginAffecteService.delete(enginAffecte);
        }
        //Insert
        List<EnginAffecteeDTO>  enginAffecteeDTOList = new ArrayList<>();
        for (EnginAffecte enginAffecte : enginAffecteList) {
            enginAffecte.setDateAffectation(new Date());
            enginAffecteeDTOList.add(new EnginAffecteeDTO(enginAffecteService.saveEnginDemande(enginAffecte)));
        }
        return enginAffecteeDTOList;
    }

    @PostMapping(value="/controler")
    String controleEnginsAffecte(@RequestBody List<EnginAffecte> enginAffecteList){
        for(EnginAffecte newEnginAffecte : enginAffecteList) {
            EnginAffecte enginAffecte = enginAffecteService.getById(newEnginAffecte.getIdDemandeEngin());
            User responsable = userService.saveUserIfNotExist(newEnginAffecte.getResponsableAffectation());
            User conducteur = userService.saveUserIfNotExist(newEnginAffecte.getConducteur());
            responsable.setType("Responsable");
            responsable.setEnable('N');
            conducteur.setEnable('N');
            conducteur.setType("Conducteur");
            enginAffecte.setResponsableAffectation(responsable);
            enginAffecte.setConducteur(conducteur);
            if (newEnginAffecte.getControleEngin().get(0).getEtatEntree() != 0)
                enginAffecte.setEtat(new Character('e'));
            else
                enginAffecte.setEtat(new Character('s'));
            if(enginAffecte.getControleEngin().isEmpty()){
                //Insert
                for (Controle controle : newEnginAffecte.getControleEngin()){
                    controle.setEnginAffecte(newEnginAffecte);
                    controleService.save(controle);
                    }
                }else{
                //Modify
                Controle newControle;
                for (Controle controle : newEnginAffecte.getControleEngin()){
                    newControle = controleService.getControlByIdCritereAndIdAffectation(controle.getCritere().getIdCritere(),newEnginAffecte.getIdDemandeEngin());
                    controle.setEnginAffecte(newEnginAffecte);
                    controle.setId(newControle.getId());
                    controleService.save(controle);
                }
            }
            enginAffecteService.saveEnginDemande(enginAffecte);
        }

        return "Done";
    }
    @GetMapping(value="/{idDemande}/{idEngin}")
    EnginDTO ElisteEnginsEntree(@PathVariable("idEngin") String idEngin,
                                @PathVariable("idDemande") String idDemande){
        Engin engin = enginService.getById(idEngin);
        Demande demande = demandeService.getById(Long.parseLong(idDemande));

        EnginDTO enginDTO = new EnginDTO(engin,demande.getEnginAffecte(idEngin));
        return enginDTO;
    }

}
