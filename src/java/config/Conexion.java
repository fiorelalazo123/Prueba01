package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    static Connection con;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mydb";
    String user = "root";
    String pass = "12345678";
    
    public Connection Conexion(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return con;
    }
    
    
      public Connection getConnection(){
   
       return con;
  } 
    
     public static Connection Conectar(){
  
        return con;
        
    }
}
