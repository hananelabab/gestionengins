package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
public class Critere implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idCritere;
    String nomCritere;

}
