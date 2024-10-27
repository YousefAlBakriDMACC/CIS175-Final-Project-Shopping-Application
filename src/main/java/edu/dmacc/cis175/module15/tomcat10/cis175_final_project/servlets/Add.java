/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author josep
 */
@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String productId = request.getParameter("productId");
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        // Define the path for products.txt
        String filePath = getServletContext().getRealPath("/") + "products.txt";

        // Write the product data to products.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Product ID: " + productId);
            writer.newLine();
            writer.write("Code: " + code);
            writer.newLine();
            writer.write("Description: " + description);
            writer.newLine();
            writer.write("Price: " + price);
            writer.newLine();
            writer.write("---------------");
            writer.newLine();
        } catch (IOException e) {
            // Handle I/O exceptions
            e.printStackTrace();
        }

        // Set response type and redirect to a confirmation page or another servlet
        response.setContentType("text/html");
        response.sendRedirect("products.jsp");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * Since we are using <code>POST</code> for form submission, this method
     * can remain unchanged unless you want specific behavior for <code>GET</code>.
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
