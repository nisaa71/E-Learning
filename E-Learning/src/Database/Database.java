/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author NANDO
 */
public class Database {
    private Connection conn;
    private Statement sta;
    private String username = "root";
    private String url = "jdbc:mysql://localhost:3306/e-learning";

    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, "");
            sta = conn.createStatement();
            System.out.println("Berhasil !!!");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean manipulate(String query)
    {
        try {
            if (sta.executeUpdate(query) >= 1)
            {
                return true;
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public ResultSet getData(String query)
    {
        try {
            return sta.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
    
    public void disconnect()
    {
        try {
            sta.close();
            conn.close();
        } catch (Exception e) {
        }
    }
            
    
    
}
