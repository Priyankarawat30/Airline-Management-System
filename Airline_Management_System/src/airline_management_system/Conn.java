
package airline_management_system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql:///airlineSystem" , "root" , "Mayank@2004");
            s = c.createStatement();
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
