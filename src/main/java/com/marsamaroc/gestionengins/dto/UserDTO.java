package com.marsamaroc.gestionengins.dto;

import com.marsamaroc.gestionengins.entity.Famille;
import com.marsamaroc.gestionengins.entity.User;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;

@Data
public class UserDTO {
	
	     Long id;
	     String nom;
	     String prenom;
	     String matricule;
	     String email;
	     String password;
	     char enable;
	     String type;
	    

    
	public UserDTO(User user){
        this.id = user.getId();
        this.prenom = user.getPrenom();
        this.matricule = user.getMatricule();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enable = user.getEnable();
        this.type = user.getType();
        this.nom = user.getNom();

    }
    
}