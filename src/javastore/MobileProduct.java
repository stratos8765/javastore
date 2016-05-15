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
public class MobileProduct extends Product{

    private String os;
    private String monitor;
    private String processor;
    private String camera;
    private String wifi;
    private String colour ;
    
    //Constructores
    public MobileProduct()
    {
        super();
        this.os = "";
        this.monitor="";
        this.processor="";
        this.camera = "";
        this.wifi="";
        this.colour= "";
        
    }
    public MobileProduct(String name,String details,int code,float price,Image[] images,String os,String monitor,String processor,String camera,String wifi,String colour)
    {
        super(name,details,code,price,images);
        this.os=os;
        this.monitor=monitor;
        this.processor=processor;
        this.camera=camera;
        this.wifi=wifi;
        this.colour=colour;
        
    }
    //end constructores
    //setters
    public void setOs(String os)
    {
        this.os = os;
        
    }
    public void setMonitor(String monitor)
    {
        this.monitor = monitor;
        
    }
    public void setProcessor(String processor)
    {
        this.processor = processor;
        
    }
    public void setCamera(String camera)
    {
        this.camera = camera;
        
    }
    public void setWifi(String wifi)
    {
        this.wifi = wifi;
        
    }
    public void setColour(String colour)
    {
        this.colour = colour;
        
    }
    //end setters
    //getters
    public String getOs()
    {
        return this.os;
        
    }
    public String getMonitor()
    {
        return this.monitor;
        
    }
    public String getProcessor()
    {
        return this.processor;
        
    }
    public String getCamera()
    {
        return this.camera;
        
    }
    public String getWifi()
    {
        return this.wifi;
        
    }
    public String getColour()
    {
        return this.colour;
        
    }
    public String toString()
    {
        
        
            String str="";
            str=str+super.toString();
            str=str+"Monitor:"+monitor+"\n"+"Processor:"+processor+"\n"+"Camera:"+camera+"\n"+"Wifi:"+wifi+"\n"+"Color:("+colour.toString()+")"+"\n";  
            return str;

    }
}

