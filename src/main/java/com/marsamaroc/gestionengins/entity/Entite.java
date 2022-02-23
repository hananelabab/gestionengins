package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Entite {

    @Id
    private String entite;

    @OneToMany(mappedBy="entite")
    List<Post> posts;



}
