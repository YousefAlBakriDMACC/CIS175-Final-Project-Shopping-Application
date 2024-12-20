/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author josep
 */
public class DBUtil {
    private static final EntityManagerFactory emf = initEntityManagerFactory();
    
    public static EntityManagerFactory initEntityManagerFactory() {
        try {
            Class.forName("Persistence");
            return Persistence.createEntityManagerFactory("musicStorePU");
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            System.out.println(e);
            return null;
        }
    }
    
    public static EntityManagerFactory getEmFactory() {
        try {
            Class.forName("EntityManagerFactory");
            return emf;
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            System.out.println(e);
            return null;
        }
    }
}
