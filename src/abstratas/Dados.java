package abstratas;

import java.sql.*;

abstract public class Dados {
        private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        if (connection == null){
        
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/livraria", "postgres", "1234");
        }
        
        return connection;
    }
}
