package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Demande;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.enums.EtatEngin;
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
            "and ea.dateAffectation = (" +
            "SELECT max(ea1.dateAffectation) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = e.codeEngin)" +
            "and (ea.etat = 'affecte' or ea.etat ='presortie')")
    List<Engin> findAllEnginAffecteAndPreSortie();

    @Query("select e from Engin e , EnginAffecte ea " +
            "where ea.engin.codeEngin= e.codeEngin " +
            "and ea.dateAffectation = (" +
            "SELECT max(ea1.dateAffectation) from EnginAffecte ea1 " +
            "where ea1.engin.codeEngin = ea.engin.codeEngin)" +
            "and ea.etat='sortie'")
    List<Engin> findAllEnginSortie();
    
    @Query("select e from Engin e"+
            " where e.etat ='"+ EtatEngin.disponible_value
            +"' and e.famille.idFamille = :#{#idFamille}")
    List<Engin> findAllEnginEntreeByFamille(@Param("idFamille") Long famille );

}
