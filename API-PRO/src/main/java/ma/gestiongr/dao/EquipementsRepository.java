package ma.gestiongr.dao;

import java.util.List;

import ma.gestiongr.entities.Equipements;

public interface EquipementsRepository {

	 List<Equipements> findAll();
}