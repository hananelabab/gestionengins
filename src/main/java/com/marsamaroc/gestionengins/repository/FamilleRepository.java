package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FamilleRepository extends JpaRepository<Famille, Long> {

}
