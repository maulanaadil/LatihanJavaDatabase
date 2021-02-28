/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carabapa;

import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author MSI GF63 9RCX
 */
public class TambahData {
    public static void main(String[] args) {
        String user = "root";
        String pass = "";
        String host = "localhost";
        String db = "java_akdmk";
        String  urlValue = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass;
            
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;
            String sql = "INSERT INTO t_mata_kuliah(`kd_mk`,`nama_mk`)"
                    + "VALUES (?,?);";
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, "IF19666");
            pStatement.setString(2, "Software Terapan");
            
            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Success Add Data");
            } else {
                System.out.println("Failed Add Data");
            }
            pStatement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connect Failed " + e.getMessage());
        } catch (ClassNotFoundException e ) {
            System.out.println("JDBC Not Found!");
        }
        
    }
    
    
}
