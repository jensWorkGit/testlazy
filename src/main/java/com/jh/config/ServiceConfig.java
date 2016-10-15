package com.jh.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;

@Configuration
public class ServiceConfig extends WebMvcConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(ServiceConfig.class);

    @Inject
    Hibernate5Module hibernate5Module;

    @Bean
    public Jackson2ObjectMapperBuilder configureObjectMapper() {
        log.info("configure Jackson2ObjectMapperBuilder");
        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
        return new Jackson2ObjectMapperBuilder().modulesToInstall(hibernate5Module);
    }
}
