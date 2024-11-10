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

/**
 *
 * @author kaleb
 */
public class ProductDB {

    public static List<Product> selectProducts() {
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

    public static Product selectProduct(String productCode) {
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

    public static boolean exists(String productCode) {
        return selectProduct(productCode) != null;
    }

    public static void insertProduct(Product product) {
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

    public static void updateProduct(Product product) {
        String query = "UPDATE Product SET ProductDescription = ?, ProductPrice = ? WHERE ProductCode = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    public static void deleteProduct(Product product) {
        String query = "DELETE FROM Product WHERE ProductCode = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, product.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    private static Connection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }
}
