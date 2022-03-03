package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface EnginRepository extends JpaRepository<Engin,String> {

    @Query("select e from Engin e , EnginAffecte ea " +
            "where ea.engin.codeEngin= e.codeEngin " +
            "and ea.dateSortie = (" +
            "SELECT max(ea1.dateSortie) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = e.codeEngin)" +
            "and ea.etat='s'")
    List<Engin> findAllEnginSortie();

    @Query("select e from Engin e , EnginAffecte ea " +
            "where ea.engin.codeEngin= e.codeEngin " +
            "and ea.dateSortie = (" +
            "SELECT max(ea1.dateSortie) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = ea.engin.codeEngin)" +
            "and ea.etat='e'")
    List<Engin> findAllEnginEntree();
    
    @Query("select e from Engin e , EnginAffecte ea " +
            "where (ea.engin.codeEngin= e.codeEngin " +
            "and ea.dateAffectation = (" +
            "SELECT max(ea1.dateAffectation) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = ea.engin.codeEngin)" +
            "and ea.etat='e'"
            + "and e.famille.idFamille = :#{#idFamille} )"
            + "or e.codeEngin not in (select ea2.engin.codeEngin from EnginAffecte ea2)")
    List<Engin> findAllEnginEntreeByFamille(@Param("idFamille") Long famille );
    
    

}
