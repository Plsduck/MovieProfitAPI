package com.Glasbrenner.NewMovieApi.Configurations;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.Glasbrenner.NewMovieApi.DAO")
public class AppConfig {

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mariadb://localhost:3306/MovieAPI");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("NightSkunk1");
        return dataSourceBuilder.build();
    }
}
