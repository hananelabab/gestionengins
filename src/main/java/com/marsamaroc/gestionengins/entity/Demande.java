package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Demande implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long NumBCI;
    Date dateDemande;
    Date dateSortie;
    int shift;
    @ManyToOne
    @JoinColumn(name = "id_post")
    Post post;
    @OneToMany(mappedBy = "demande")
    List<DetailsDemande> detailsDemandeList;
    @OneToMany(mappedBy = "demande")
    List<EnginAffecte> enginsAffecteList;

    @ManyToOne
    @JoinColumn(name = "demande_responsable")
    private User user;

    public int getQuantite(){
        int totalEngin=0;
        for(DetailsDemande detailsDemande : this.getDetailsDemandeList())
            totalEngin+= detailsDemande.getQuantite();
        return totalEngin;
    }
    public String getStatut(){
        if(this.enginsAffecteList == null)
            return "Enregistée";
        if(this.enginsAffecteList.isEmpty())
            return "Enregistée";
        return "Verifiée";
    }
    public EnginAffecte getEnginAffecte(String idEngin){
        for (EnginAffecte enginAffecte : enginsAffecteList){
            if(enginAffecte.getEngin().getCodeEngin().equals(idEngin))
                return enginAffecte;
        }

        return null;

    }
}
