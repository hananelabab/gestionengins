package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMatricule(String matricule);
}
