
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login_Model;

/**
 *
 * @author sen
 */
public class Login_Controller {
    private Connection conn;

    public Login_Controller(Connection connection) {
        this.conn=connection;
        
    }
    public boolean login(Login_Model modelLogin)
    {
        String  query= "SELECT * FROM tbLogin WHERE username=? AND password=?";
        try {
            PreparedStatement pst=ConnectDB.getConnection().prepareStatement(query);
            pst.setString(1, modelLogin.getUname());
            pst.setString(2, modelLogin.getPass());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                return true;
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Login_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
}
