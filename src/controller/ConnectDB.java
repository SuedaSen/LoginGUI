
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sen
 */
public class ConnectDB {
        
private static Connection conn;
private ResultSet rst;
private PreparedStatement pst;

    public ConnectDB() {
    }

public static Connection getConnection(){
    try{
        Class.forName("org.sqlite.JDBC");
        conn=DriverManager.getConnection("jdbc:sqlite:src/database/dbLogin.db");
    } catch(SQLException | ClassNotFoundException ex)
    {
        ex.printStackTrace();
    }
    return conn;
}
}
