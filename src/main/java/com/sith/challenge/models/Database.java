package com.sith.challenge.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/librarysith";

    public Connection getConnection(){

        try {
            Class.forName(DRIVER);
            System.out.println("driver no try!");
            return DriverManager.getConnection(URL, "developer", "kvy2MfTA!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error on database, class not found: " + e);
        } catch (SQLException ex) {
            System.out.println("Error on database, Sql exception: " + ex);
        }
        System.out.println("problema com o driver!");
        return null;
    }

}
