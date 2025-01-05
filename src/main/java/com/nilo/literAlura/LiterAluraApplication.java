package com.nilo.literAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nilo.literAlura.principal.Principal;
import com.nilo.literAlura.repository.BookRepository;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    @Autowired
    private BookRepository repositorio;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repositorio);
        principal.exibeMenu();
    }
}
