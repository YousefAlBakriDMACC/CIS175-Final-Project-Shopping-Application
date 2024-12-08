/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author josep
 */
public class UserDB {
    //Master
    public static void addUser(String username, String password, String rolename) {
        try {
            addUserJPA(username, password, rolename);
        } catch (Exception | Error e) {
            addUserJDBC(username, password, rolename);
        }
    }
    
    public static void deleteUser(String username, String password, String rolename) {
        try {
            deleteUserJPA(username, password, rolename);
        } catch (Exception | Error e) {
            deleteUserJDBC(username, password, rolename);
        }
    }
    
    
    //JPA
    public static void addUserJPA(String username, String password, String rolename) {
        throw new UnsupportedOperationException("User has no corresponding JPA entity");
    }
    
    public static void deleteUserJPA(String username, String password, String rolename) {
        throw new UnsupportedOperationException("User has no corresponding JPA entity");
    }
    
    
    //JDBC
    public static void addUserJDBC(String username, String password, String rolename) {
        String query = "INSERT INTO Credentials(username, password, rolename) SELECT ?, ?, ? FROM DUAL";
        query += " WHERE NOT EXISTS (SELECT * FROM Credentials WHERE username = ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, rolename);
            ps.setString(4, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(5/ 0);
        }
    }
    
    public static void deleteUserJDBC(String username, String password, String rolename) {
        String query = "DELETE FROM Credentials WHERE username = ? AND password = ? AND rolename = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, rolename);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private static Connection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }
}
