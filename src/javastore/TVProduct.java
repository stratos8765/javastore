/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.Image;

/**
 *
 * @author 3oxic
 */
public class TVProduct extends Product{
    private int inches;
    private String hd;

    public TVProduct() 
    {
        super();
        
        this.inches=0;
        this.hd="";
        
    }

    public TVProduct(int inches, String hd, String name, String details, int code, float price, Image[] images) 
    {
        super(name, details, code, price, images);
        this.inches = inches;
        this.hd = hd;
    }
//getters
    public int getInches() {
        return inches;
    }

    public String getHd() {
        return hd;
    }
    //end getters
    
//setters
    public void setInches(int inches) {
        this.inches = inches;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }
    //end setters
    
    
    
}
