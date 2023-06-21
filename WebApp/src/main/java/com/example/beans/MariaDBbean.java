package com.example.beans;

import java.sql.DriverManager;
import java.sql.Connection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.springframework.web.context.WebApplicationContext;

@Component
@Scope("singleton")
public class MariaDBbean {

    private Connection connection;

    public MariaDBbean() {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/database_name",
                    "root", "NightSkunk1"
            );
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


}
