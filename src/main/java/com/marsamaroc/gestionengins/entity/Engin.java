package com.marsamaroc.gestionengins.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Engin implements Serializable {
    @Id
    String codeEngin;
    String typeEngin;
    String capacite;
    Long compteur;
    public Famille get_Famille() {
    	return this.famille;
    }
    @ManyToOne
    @JoinColumn(name = "id_famille")
    Famille famille;

    @OneToMany(mappedBy = "engin")
    List<EnginAffecte> enginAffecteList;


    public EnginAffecte getDerniereAffectation(){
        EnginAffecte dernierEnginAffecte  = null;
        if(!enginAffecteList.isEmpty()){
        	
            dernierEnginAffecte = enginAffecteList.get(0);
            for(EnginAffecte enginAffecteitm : enginAffecteList){
                if(enginAffecteitm.getDateAffectation().compareTo(dernierEnginAffecte.getDateAffectation())>=1)
                    dernierEnginAffecte = enginAffecteitm;
            }
        }

        return dernierEnginAffecte;
    }
}
