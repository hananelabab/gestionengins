package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Controle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ControleRepository extends JpaRepository<Controle, Long> {

    void deleteByEnginAffecteIdDemandeEngin(Long idDemandeEngin);
    Controle findAllByCritere_IdCritereAndEnginAffecte_IdDemandeEngin(Long idCritere, Long idDemandeEngin);
}
