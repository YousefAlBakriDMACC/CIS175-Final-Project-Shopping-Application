/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author josep
 */
public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource)(ic.lookup("java:/comp/env/jdbc/music_store"));
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
    
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //return dataSource.getConnection();
            String dbURL = "jdbc:mysql://localhost:3306/music";
            String username = "root";
            String password = "sesame";
            return DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void freeConection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}