package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.DetailsDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsDemandeRepository extends JpaRepository<DetailsDemande,Long> {

}
