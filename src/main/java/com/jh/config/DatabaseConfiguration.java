package com.jh.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean
    public Hibernate5Module hibernate5Module() {
        log.info("bean for hibernate5Module");
        return new Hibernate5Module();
    }
}
