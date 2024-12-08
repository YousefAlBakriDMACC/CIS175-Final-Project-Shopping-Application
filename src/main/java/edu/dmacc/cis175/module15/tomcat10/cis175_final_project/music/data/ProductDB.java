/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data;

import edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.FileReader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.io.BufferedReader;
import java.sql.Statement;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 *
 * @author kaleb
 */
public class ProductDB {
    //Master
    public static void init(String filepath) {
        try {
            initJPA(filepath);
        } catch (Exception | Error e) {
            initJDBC(filepath);
        }
    }

    public static List<Product> selectProducts() {
        try {
            return selectProductsJPA();
        } catch (Exception | Error e) {
            return selectProductsJDBC();
        }
    }
    
    public static Product selectProduct(String productCode) {
        try {
            return selectProductJPA(productCode);
        } catch (Exception | Error e) {
            return selectProductJDBC(productCode);
        }
    }
    
    public static boolean exists(String productCode) {
        try {
            return existsJPA(productCode);
        } catch (Exception | Error e) {
            return existsJDBC(productCode);
        }
    } 
    
    public static void insertProduct(Product product) {
        try {
            insertProductJPA(product);
        } catch (Exception | Error e) {
            insertProductJDBC(product);
        }
    }
    
    public static void updateProduct(Product product) {
        try {
            updateProductJPA(product);
        } catch (Exception | Error e) {
            updateProductJDBC(product);
        }
    }
    
    public static void deleteProduct(Product product) {
        try {
            deleteProductJPA(product);
        } catch (Exception | Error e) {
            deleteProductJDBC(product);
        }
    }
    
    
    //JPA
    public static void initJPA(String filepath) {
        throw new UnsupportedOperationException();
    }
    
    public static List<Product> selectProductsJPA() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String selectQuery = "SELECT productObj FROM Product productObj";
        TypedQuery<Product> myQuery = em.createQuery(selectQuery, Product.class);
        List<Product> myResultSet;
        
        try {
            myResultSet = myQuery.getResultList();
        } finally {
            em.close();
        }
        
        //Standardize not empty
        if (myResultSet == null || myResultSet.isEmpty()) {
            return null;
        } else {
            return myResultSet;
        }
    }
    
    public static Product selectProductJPA(String productCode) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Product p = null;
        
        try {
            p = em.find(Product.class, productCode);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        
        return p;
    }
    
    public static boolean existsJPA(String productCode) {
        return selectProductJPA(productCode) != null;
    }
    
    public static void insertProductJPA(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
        }
    
    public static void updateProductJPA(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void deleteProductJPA(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    
    //JDBC
    public static void initJDBC(String filepath) {
        try (Connection conn = getConnection(); Statement s = conn.createStatement();) {
            BufferedReader scriptReader = new BufferedReader(new FileReader(filepath));
            StringBuilder queryBuilder = new StringBuilder();
            String line;
            while ((line = scriptReader.readLine()) != null) {
                if (line.trim().startsWith("-- ")) {
                    continue;
                }
                queryBuilder.append(line).append(' ');  //Append line
                if (line.trim().endsWith(";")) {
                    //Execute and end query
                    s.execute(queryBuilder.toString().trim());
                    //Empty queryBuilder for next query
                    queryBuilder = new StringBuilder();
                }
            }
            
            ScriptRunner scriptRunner = new ScriptRunner(conn);
            scriptRunner.setSendFullScript(true);
            scriptRunner.setStopOnError(true);
            scriptRunner.setAutoCommit(true);
            scriptRunner.runScript(new FileReader(filepath));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Product> selectProductsJDBC() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT ProductID, ProductCode, ProductDescription, ProductPrice FROM Product";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("ProductID"));
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
        return products;
    }

    public static Product selectProductJDBC(String productCode) {
        String query = "SELECT ProductID, ProductCode, ProductDescription, ProductPrice FROM Product WHERE ProductCode = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, productCode);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getInt("ProductID"));
                    p.setCode(rs.getString("ProductCode"));
                    p.setDescription(rs.getString("ProductDescription"));
                    p.setPrice(rs.getDouble("ProductPrice"));
                    return p;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
        return null;
    }

    public static boolean existsJDBC(String productCode) {
        return selectProductJDBC(productCode) != null;
    }

    public static void insertProductJDBC(Product product) {
        String query = "INSERT INTO Product (ProductCode, ProductDescription, ProductPrice) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    public static void updateProductJDBC(Product product) {
        String query = "UPDATE Product SET ProductCode = ?, ProductDescription = ?, ProductPrice = ? WHERE ProductID = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    public static void deleteProductJDBC(Product product) {
        String query = "DELETE FROM Product WHERE ProductId = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    private static Connection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }
}
