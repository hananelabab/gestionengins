package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.EnginAffecte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RestResource
public interface EnginAffecteRepository extends JpaRepository<EnginAffecte,Long> {

    List<EnginAffecte> findAllByEngin_CodeEngin(String codeEngin);
}
