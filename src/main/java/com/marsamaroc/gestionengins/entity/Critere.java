package com.marsamaroc.gestionengins.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Critere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idCritere;
    String nomCritere;

}
