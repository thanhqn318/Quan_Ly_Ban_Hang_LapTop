/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Helper {

    public static Connection ketnoi(String database) {
        try {
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-SQI2KBJ:1433;databaseName=LapTopStore";
            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                JOptionPane.showMessageDialog(null, "Kết nối thành công");
            }
            else{
                JOptionPane.showMessageDialog(null, "Lỗi kết nối");
                System.exit(0);
            }
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
