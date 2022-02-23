package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Post {
    @Id
    Long codePost;
    @ManyToOne
    @JoinColumn(name = "id_entite")
    Entite entite;

}
