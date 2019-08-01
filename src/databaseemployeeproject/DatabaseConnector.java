/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseemployeeproject;
import java.sql.*;
/**
 *
 * @author 91030283
 */
public class DatabaseConnector {
    
    
    public static Connection connectToDatabase() throws SQLException{
        String url= "jdbc:mysql://localhost:3306/";
        String database ="employeedatabase";
        String username= "root";
        String password="password";
        return DriverManager.getConnection(url + database,username,password);
    }
    
    public static void closeConnection(Connection con)throws SQLException
    {
        con.close();
    }
    
}
