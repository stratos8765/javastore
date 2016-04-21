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
    private Color colour = new Color();
    
    //Constructores
    public MobileProduct()
    {
        super();
        this.os = "";
        this.monitor="";
        this.processor="";
        this.camera = "";
        this.wifi="";
        this.colour= new Color();
        
    }
    public MobileProduct(String name,String details,int code,float price,Image[] images,String os,String monitor,String processor,String camera,String wifi,Color colour)
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
    public void SetOs(String os)
    {
        this.os = os;
        
    }
    public void SetMonitor(String monitor)
    {
        this.monitor = monitor;
        
    }
    public void SetProcessor(String processor)
    {
        this.processor = processor;
        
    }
    public void SetCamera(String camera)
    {
        this.camera = camera;
        
    }
    public void SetWifi(String wifi)
    {
        this.wifi = wifi;
        
    }
    public void SetColour(Color colour)
    {
        this.colour = colour;
        
    }
    //end setters
    //getters
    public String GetOs()
    {
        return this.os;
        
    }
    public String GetMonitor()
    {
        return this.monitor;
        
    }
    public String GetProcessor()
    {
        return this.processor;
        
    }
    public String GetCamera()
    {
        return this.camera;
        
    }
    public String GetWifi()
    {
        return this.wifi;
        
    }
    public Color GetColour()
    {
        return this.colour;
        
    }
    public String toString()
    {
        
        
            String str="";
            str=str+super.toString();
            str=str+"Monitor:"+monitor+"Processor:"+processor+"Camera:"+camera+"Wifi:"+wifi+"Color:("+colour.toString()+")";
            
            return str;
            
    }
}

