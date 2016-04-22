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
    public void setProcessor(String processor)
    {
        this.processor=processor;
       
    }
    public void setSsd(String ssd)
    {
        this.ssd=ssd;
       
    }
    public void setRam(String ram)
    {
        this.ram=ram;
       
    }
    public void setCdrom(String cdrom)
    {
        this.cdrom=cdrom;
       
    }
    public void setGraphicsCard(String graphicscard)
    {
        this.graphicscard=graphicscard;
       
    }
    //end setters
    //getters
    public String getCdrom()
    {
        return this.cdrom;
        
    }
    public String getGraphicsCard()
    {
        return this.graphicscard;
        
    }
    public String getProcessor()
    {
        return this.processor;
        
    }
    public String getRam()
    {
        return this.ram;
        
    }
    public String getSsd()
    {
        return this.ssd;
        
    }
    //end getters
    public String toString()
    {
       String str="";
       str=super.toString();
       str=str+" Cd Rom:"+cdrom+"\n"+" Graphics Card:"+graphicscard+"\n"+" Processor:"+processor+"\n"+" Ram:"+ram+"\n"+" SSD:"+ssd+"\n";
       
       return str;
       
    }
}
