package com.chahan.domain.config;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class DbMigration {

    private DbMigration() {
    }

    public static void configure(DataSource dataSource) {
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
