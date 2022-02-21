package com.example.mcqround1.init;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class FlywayConfig
{
    @Value("${flyway.script.location}")
    private String flyWayLocation;

    @Autowired
    private DataSource dataSource;


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        Flyway flyway =Flyway.configure().locations(flyWayLocation).dataSource(dataSource).load();
        flyway.repair();
        flyway.migrate();
    }

}
