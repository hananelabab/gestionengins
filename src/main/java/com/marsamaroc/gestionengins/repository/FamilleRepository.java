package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface FamilleRepository extends JpaRepository<Famille, String> {

    Famille findByNomFamille(String nomFamille);

}
