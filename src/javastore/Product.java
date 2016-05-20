/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author 3oxic
 */
public abstract class Product {
    private String name;
    private String details;
    private int code;
    private float price;
    private String str;
    
    private ArrayList<Image> images = new ArrayList<Image>();
    
        //Constructors
    public Product()
    {
        this.name="";
        this.details="";
        this.code = 0;
        this.price = 0;
        
    }
    public Product(String name,String details,int code,float price,ArrayList<Image> images)
    {
        this.name=name;
        this.details=details;
        this.code=code;
        this.price=price;
        this.images=images;
        
    }
    
    //setters
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDetails(String details)
    {
        this.details=details;
        
    }
    public void setCode(int code)
    {
        this.code=code;
        
    }
    public void setPrice(float price)
    {
        this.price=price;
        
    }
    public void setImages(ArrayList<Image> images)
    {
        this.images=images;
        
    }
    //end setters
    
    //getters
    public String getName()
    {
        return this.name;
        
    }
      public String getDetails()
    {
        return this.details;
        
    }
        public int getCode()
    {
        return this.code;
        
    }
          public float getPrice()
    {
        return this.price;
        
    }
            public ArrayList<Image> getImages()
    {
        return this.images;
        
    }
         //end getters
            
       public String toString()
   {
       str= "name:" + name +"\n"+ "details:" + details +"\n"+ "code:" + code +"\n"+ "price:" + price+"\n";
       
      return str;
   }
}
