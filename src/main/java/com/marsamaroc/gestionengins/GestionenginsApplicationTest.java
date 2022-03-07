package com.marsamaroc.gestionengins;

import com.marsamaroc.gestionengins.repository.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
public class GestionenginsApplicationTest implements CommandLineRunner {

    @Autowired
    static
    FamilleRepository familleRepository;

    @Override
    public void run(String... args) throws Exception {
    }
    public static void main(String[] args)
    {
    }
}
