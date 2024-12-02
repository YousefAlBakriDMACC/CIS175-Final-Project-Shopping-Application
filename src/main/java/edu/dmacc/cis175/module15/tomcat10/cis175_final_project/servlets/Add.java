/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product;
import edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductDB;

/**
 *
 * @author josep
 */
@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            
        if (request.getParameter("save").equals("Save Product")) {
            //Retrieve product data from form
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price").replace('$', '0'));

            //Add new product to file
            Product product = new Product();
            product.setCode(code);
            product.setDescription(description);
            product.setPrice(price);
            ProductDB.insertProduct(product);
            request.getSession().removeAttribute("storedProductAdd");
        }
        if (request.getParameter("save").equals("View Products")) {
            //Persist current data
            String code = (request.getParameter("code") != null)? request.getParameter("code") : "";
            String description = (request.getParameter("description") != null)? request.getParameter("description") : "";
            double price = (request.getParameter("price") != null)? Double.parseDouble(request.getParameter("price").replace('$', '0')) : 0.00;

            //Add new product to file
            Product product = new Product();
            product.setCode(code);
            product.setDescription(description);
            product.setPrice(price);
            request.getSession().setAttribute("storedProductAdd", product);
        }
        
        
        //Return to main
        String url = "/products.jsp";
        request.getServletContext().getRequestDispatcher(url).forward(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
