/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package config;

/**
 *
 * @author MSI GF63 9RCX
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class Config {
    
    private static Connection MySQLConfig;
    
    public static Connection configDB() throws SQLException, ClassNotFoundException {
            try {
                String url = "jdbc:mysql://localhost:3306/java_akdmk";
                String user = "root";
                String pass = "";
            
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                MySQLConfig = DriverManager.getConnection(url, user, pass);
                System.out.println("Success Connect to Database");            
         } catch (SQLException e) {
                System.out.println("Failed Connect to Database" + e.getMessage());
         }
            return MySQLConfig;
    }
}
