/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adilversion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.Config;

/**
 *
 * @author MSI GF63 9RCX
 */
public class SearchData {
    public static void main(String[] args) throws SQLException  {
        Statement pstm;
        try (Connection conn = (Connection) Config.configDB()) {
            pstm = conn.createStatement();
            ResultSet rs = pstm.executeQuery("SELECT * FROM t_mata_kuliah;");
            int no = 0;
            while(rs.next()) {
                no = no + 1;
                System.out.println("No                  : "+ no);
                System.out.println("Kode Mata Kuliah    : "+ rs.getString("kd_mk"));
                System.out.println("Nama Mata Kuliah    : "+ rs.getString("nama_mk"));
                System.out.println("");
            }   if (no == 0) {
                System.out.println("Data Not Found");
            }
            conn.close();
            pstm.close();   
        }
    }
    
    
}
