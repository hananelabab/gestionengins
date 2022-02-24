package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(path = "criteres")
public interface CritereRepository extends JpaRepository<Critere,Long> {

}
