/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usaid
 */
public class ConnectDB {
    private static Connection connect;
    public static Connection getConnected()
    {
        if(connect== null)
        {
            try {
                String url="jdbc:mysql://localhost/rc_pos";
                String username= "root";     
                String password= "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect =DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return connect;
    }
}
