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
public abstract class Product {
    private String name;
    private String details;
    private int code;
    private float price;
    private Image[] images = new Image[20];
    
        //Constructors
    public Product()
    {
        this.name="";
        this.details="";
        this.code = 0;
        this.price = 0;
        
    }
    public Product(String name,String details,int code,float price,Image[] images)
    {
        this.name=name;
        this.details=details;
        this.code=code;
        this.price=price;
        this.images=images;
        
    }
}
