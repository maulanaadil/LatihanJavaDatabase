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
public class UpdateData {
    public static void main(String[] args) throws SQLException {
        String sql = "UPDATE t_mata_kuliah SET nama_mk=? WHERE kd_mk='IF19666'";
        try (Connection conn = (Connection) Config.configDB()) {
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, "Matematika Diskrit");
            
            int intBaris = pstm.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Update Data Succes");
            } else {
                System.out.println("Update Data Failed");
            }
            conn.close();
            pstm.close();
        }
    }
    
}
