package com.marsamaroc.gestionengins;

import com.marsamaroc.gestionengins.repository.FamilleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GestionenginsApplicationTests {

	@Autowired
	FamilleRepository familleRepository;

	@Test
	void contextLoads() {
	}


}
