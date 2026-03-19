package br.com.hunsriqueano.libelle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LibelleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibelleApplication.class, args);
    }

}
