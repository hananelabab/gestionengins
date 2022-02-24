package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
public class Post implements Serializable {
    @Id
    Long codePost;
    @ManyToOne
    @JoinColumn(name = "id_entite")
    Entite entite;

}
