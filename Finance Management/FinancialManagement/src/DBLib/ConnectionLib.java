/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLib;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Minh Tân
 */
public class ConnectionLib {
    private static String URL = "jdbc:mysql://localhost:3306/financialmanagement";
    private static String UID = "root";
    private static String PWD = "";
    private static Connection con;
    
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = (Connection) DriverManager.getConnection(URL, UID, PWD);
        return con; 
    }
}
