package com.marsamaroc.gestionengins;

import com.marsamaroc.gestionengins.repository.CritereRepository;
import com.marsamaroc.gestionengins.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class GestionenginsApplication implements CommandLineRunner {

    @Autowired
    CritereRepository crtiterRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionenginsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test");
        crtiterRepository.findAll();
    }
}
