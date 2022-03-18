package ma.gestiongr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gestiongr.dao.EquipementsRepository;
import ma.gestiongr.entities.Equipements;

@Service

public class BeanService implements EquipementsService {

	@Autowired
	private EquipementsRepository equipementsrepository;

	@Override
	public Collection<Equipements> findAll() {
		Collection<Equipements> equipements =  (Collection<Equipements>) equipementsrepository.findAll();
		return equipements;
	}

}
