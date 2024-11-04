/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.tags;

import jakarta.servlet.jsp.*; 
import jakarta.servlet.jsp.tagext.*; 
import edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO;

/**
 *
 * @author josep
 */
public class ProductsTag extends TagSupport {
    private String path;
    
    public void setPath(String relativeFilePath) {
        this.path = relativeFilePath;
    }
    
    @Override
    public int doStartTag() throws JspException {
        try {
            String realDataPath = ProductsServletContextListner.getServletContext().getRealPath(path);
            ProductIO.init(realDataPath);
        }
        catch (Exception e) { 
            System.out.println(e); 
        }
        return SKIP_BODY;
    }
}