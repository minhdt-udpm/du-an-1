
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBUtils;

/* @author Hoang */

public class GenericDAO {
    
    Connection connection;

    public GenericDAO() {

    }
    
    protected PreparedStatement getPreparedStatement(String sql){
        try {
            connection = DBUtils.getConnection();
            return connection.prepareStatement(sql);
            
        } catch (SQLException e) {
            System.out.println("getPreparedStatement: " + e);
            return null;
        }
    }    
    
        
        
        
        
        
        
        
        
        
        
    
}
