package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnginRepository extends JpaRepository<Engin,String> {

    @Query("select e from Engin e , EnginAffecte ea " +
            "where ea.engin.codeEngin= e.codeEngin " +
            "and ea.dateSortie = (" +
            "SELECT max(ea1.dateSortie) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = ea.engin.codeEngin)" +
            "and ea.etat='s'")
    List<Engin> findAllEnginSortie();

    @Query("select e from Engin e , EnginAffecte ea " +
            "where ea.engin.codeEngin= e.codeEngin " +
            "and ea.dateSortie = (" +
            "SELECT max(ea1.dateSortie) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = ea.engin.codeEngin)" +
            "and ea.etat='e'")
    List<Engin> findAllEnginEntree();

}
