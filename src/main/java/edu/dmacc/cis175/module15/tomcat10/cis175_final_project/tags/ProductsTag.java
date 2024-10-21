/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.tags;

import java.io.*;
import jakarta.servlet.jsp.*; 
import jakarta.servlet.jsp.tagext.*; 

/**
 *
 * @author josep
 */
public class ProductsTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try { 
            JspWriter out = pageContext.getOut();
            if (ProductsServletContextListner.generateRealFilePath("/WEB-INF/data/products.txt").equals("")) {
                out.print("Servlet Context not initialized");
            }
            else {
                out.print(ProductsServletContextListner.generateRealFilePath("/WEB-INF/data/products.txt"));
            }
        }
        catch (IOException ioe) { 
            System.out.println(ioe); 
        }
        return SKIP_BODY;
    }
}