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
    DetailsDemandeRepository detailsDemandeRepository;

    @Override
    public void saveDetailDemandes(List<DetailsDemande> detailsDemande, Demande demande ) {
        detailsDemandeRepository.deleteAll(demande.getDetailsDemandeList());
        for(DetailsDemande detailsDemand:detailsDemande) {
            detailsDemand.setDemande(demande);
            detailsDemandeRepository.save(detailsDemand);
        }
        // TODO Auto-generated method stub

    }

    @Override
    public DetailsDemande getDetailsDemandeByNumBciAndIdFammille(Long numBci, Long idFamille) {
        return detailsDemandeRepository.findByDemande_NumBCIAndFamille_IdFamille(numBci,idFamille);
    }
}
