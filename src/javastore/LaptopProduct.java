package javastore;


import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 3oxic
 */
public class LaptopProduct extends Product {
    private String processor;
    private String ram;
    private String graphicscard;
    private String ssd;
    private String cdrom;
    
    //constructors
    public LaptopProduct()
    {
        super();
        this.processor="";
        this.ssd="";
        this.graphicscard="";
        this.cdrom="";
        this.ram="";
        
    }
    
    public LaptopProduct(String name,String details,int code,float price,Image[] images,String processor,String graphicscard,String ssd,String cdrom,String ram)
    {
        super(name,details,code,price,images);
        this.processor=processor;
        this.ssd=ssd;
        this.graphicscard=graphicscard;
        this.cdrom=cdrom;
        this.ram=ram;
        
    }
    //end constructors
    //setters
    public void SetProcessor(String processor)
    {
        this.processor=processor;
       
    }
    public void SetSsd(String ssd)
    {
        this.ssd=ssd;
       
    }
    public void SetRam(String ram)
    {
        this.ram=ram;
       
    }
    public void SetCdrom(String cdrom)
    {
        this.cdrom=cdrom;
       
    }
    public void SetGraphicsCard(String graphicscard)
    {
        this.graphicscard=graphicscard;
       
    }
    //end setters
    //getters
    public String GetCdrom()
    {
        return this.cdrom;
        
    }
    public String GetGraphicsCard()
    {
        return this.graphicscard;
        
    }
    public String GetProcessor()
    {
        return this.processor;
        
    }
    public String GetRam()
    {
        return this.ram;
        
    }
    public String GetSsd()
    {
        return this.ssd;
        
    }
    //end getters
    
}
