/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.tags;

import java.io.IOException;
import jakarta.servlet.jsp.tagext.*; 

/**
 *
 * @author josep
 */
public class ValidateFieldTag extends BodyTagSupport {
    private String value = null;
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public int doEndTag() {
        try {
            //No param provided
            if (value == null) {
                //No param or body provided: assume empty
                if (this.getBodyContent() == null) {
                    value = "";
                } else {
                    value = this.getBodyContent().getString();
                }
            }
            
            if (value.equals("") || value.equals("$0.00") || (value.matches("[-+]?[0-9]*\\.?[0-9]+") && Double.parseDouble(value) == 0)) {
                pageContext.getOut().print("*");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return EVAL_PAGE;
    }
}
