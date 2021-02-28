/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adilversion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.Config;

/**
 *
 * @author MSI GF63 9RCX
 */
public class DeleteData {
    public static void main(String[] args) throws SQLException {
        
        String sql = "DELETE FROM t_mata_kuliah WHERE kd_mk=?;";
        PreparedStatement pstm;
        try (Connection conn = (Connection) Config.configDB()) {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "IF19888");
            int intBaris = pstm.executeUpdate();
            if (intBaris > 0 ) {
                System.out.println("DELETE Data Succes");
            } else {
                System.out.println("DELETE Data Failed");
            }
            conn.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Failed Connection to Database"+ e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Not Found" + e.getMessage());
        }    
    }
}
