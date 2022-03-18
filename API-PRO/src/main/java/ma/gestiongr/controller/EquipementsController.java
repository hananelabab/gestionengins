package ma.gestiongr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.gestiongr.dao.EquipementsRepository;
import ma.gestiongr.entities.Equipements;

@RestController
@RequestMapping("/api")
public class EquipementsController {

	@Autowired
	private EquipementsRepository equipementsrepository;

	@RequestMapping(value = "/equipements", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Equipements>> getAllEquipementss(@RequestParam(required = false) String title) {
		try {
			List<Equipements> Equipements = new ArrayList<Equipements>();

			if (title == null)
				equipementsrepository.findAll().forEach(Equipements::add);

			if (Equipements.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Equipements, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
