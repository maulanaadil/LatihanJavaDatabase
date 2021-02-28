/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adilversion;

import java.sql.Connection;
import java.sql.SQLException;
import config.Config;

/**
 *
 * @author MSI GF63 9RCX
 */
public class AddData {
    public static void main(String[] args) throws SQLException {
        String sql = "INSERT INTO t_mata_kuliah(`kd_mk`,`nama_mk`)"
                    + "VALUES (?,?);";
        try (Connection conn = (Connection) Config.configDB()) {
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, "IF19888");
            pstm.setString(2, "Pemograman Web");
            
            int intBaris = pstm.executeUpdate();
            if (intBaris > 0 ) {
                System.out.println("Add Data Success");
            } else {
                System.out.println("Add Data Failed");
            }
            conn.close();
            pstm.close();    
        } catch (SQLException e) {
            System.out.println("Connection Database Failed" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Not Found" + e.getMessage());
        }
    }
}
