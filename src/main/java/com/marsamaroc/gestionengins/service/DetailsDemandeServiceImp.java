package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.DetailsDemande;
import com.marsamaroc.gestionengins.repository.DetailsDemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsDemandeServiceImp implements  DetailsDemandeService{

    @Autowired
    DetailsDemandeRepository demandeRepository;

    @Override
    public void saveDetailDemandes(List<DetailsDemande> detailsDemande, Demande demande ) {
        for(DetailsDemande detailsDemand:detailsDemande) {
            detailsDemand.setDemande(demande);
            demandeRepository.save(detailsDemand);
        }
        // TODO Auto-generated method stub

    }
}
