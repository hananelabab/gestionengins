package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Famille;
import com.marsamaroc.gestionengins.entity.DetailsDemande;
import lombok.Data;

@Data
public class FamilleDemandeDTO {
    Long id;
    String nomFamille;
    String icon;
    int quantite;
    public FamilleDemandeDTO(DetailsDemande detailsDemande){
        this.id= detailsDemande.getFamille().getIdFamille();
        this.nomFamille= detailsDemande.getFamille().getNomFamille();
        this.icon= detailsDemande.getFamille().getIcon();
        this.quantite= detailsDemande.getQuantite();
    }
    DetailsDemande convertToEntity(Demande demande){
        Famille famille = new Famille();
        famille.setIdFamille(id);
        famille.setNomFamille(nomFamille);
        famille.setIcon(icon);
        DetailsDemande detailsDemande = new DetailsDemande();
        detailsDemande.setFamille(famille);
        detailsDemande.setDemande(demande);
        detailsDemande.setId(id);
        return detailsDemande;
    }
}
