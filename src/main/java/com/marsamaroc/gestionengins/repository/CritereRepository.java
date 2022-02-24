package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface CritereRepository extends JpaRepository<Critere,Long> {
}
