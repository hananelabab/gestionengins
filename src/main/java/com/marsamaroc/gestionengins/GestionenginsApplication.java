package com.marsamaroc.gestionengins;

import com.marsamaroc.gestionengins.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class GestionenginsApplication implements CommandLineRunner {

    @Autowired
    DemandeService demandeService;

    public static void main(String[] args) {
        SpringApplication.run(GestionenginsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //demandeService.findAllDemande();
    }
}
