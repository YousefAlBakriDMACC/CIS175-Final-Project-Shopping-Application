/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.tags;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 *
 * @author josep
 */
public final class ProductsServletContextListner implements ServletContextListener  {
    private static ServletContext context = null;
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();
    }
    
    public static ServletContext getServletContext() {
        return context;
    }
}
