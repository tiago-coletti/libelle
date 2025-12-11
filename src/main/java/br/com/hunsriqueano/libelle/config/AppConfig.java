package br.com.hunsriqueano.libelle.config;

import org.apache.commons.codec.language.ColognePhonetic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ColognePhonetic colognePhonetic() {
        return new ColognePhonetic();
    }
}