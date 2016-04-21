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
    private String str;
    
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
    
    //setters
    public void SetName(String name)
    {
        this.name=name;
    }
    public void SetDetails(String details)
    {
        this.details=details;
        
    }
    public void SetCode(int code)
    {
        this.code=code;
        
    }
    public void SetPrice(float price)
    {
        this.price=price;
        
    }
    public void SetImages(Image[] images)
    {
        this.images=images;
        
    }
    //end setters
    
    //getters
    public String GetName()
    {
        return this.name;
        
    }
      public String GetDetails()
    {
        return this.details;
        
    }
        public int GetCode()
    {
        return this.code;
        
    }
          public float GetPrice()
    {
        return this.price;
        
    }
            public Image[] GetImages()
    {
        return this.images;
        
    }
         //end getters
            
       public String toString()
   {
       str= "name:" + name + "details:" + details + "code:" + code + "price:" + price;
       
      return str;
   }
}
