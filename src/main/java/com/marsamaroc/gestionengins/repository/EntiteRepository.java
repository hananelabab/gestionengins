package com.marsamaroc.gestionengins.repository;


import com.marsamaroc.gestionengins.entity.Entite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(path = "entites")
public interface EntiteRepository extends JpaRepository<Entite, Long> {
}
