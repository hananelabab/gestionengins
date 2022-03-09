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
    Long idFammile;
    int quantite;
    public FamilleDemandeDTO(DetailsDemande detailsDemande){
        this.idFammile = detailsDemande.getFamille().getIdFamille();
        this.id= detailsDemande.getId();
        this.nomFamille= detailsDemande.getFamille().getNomFamille();
        this.icon= detailsDemande.getFamille().getIcon();
        this.quantite= detailsDemande.getQuantite();
    }
    DetailsDemande convertToEntity(Demande demande){
        Famille famille = new Famille();
        famille.setIdFamille(idFammile);
        famille.setNomFamille(nomFamille);
        famille.setIcon(icon);
        DetailsDemande detailsDemande = new DetailsDemande();
        detailsDemande.setFamille(famille);
        detailsDemande.setDemande(demande);
        detailsDemande.setId(id);
        return detailsDemande;
    }
}
