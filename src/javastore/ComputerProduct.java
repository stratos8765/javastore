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
public class ComputerProduct extends Product{
    //Επεξεργαστής, Μνήμη, Κάρτα Γραφικών, Οθόνη, Λειτουργικό
    private String processor;
    private String ram;
    private String graphicscard;
    private String monitor;
    private String os;
    
    
    //Constructores
    public ComputerProduct()
    {
        super();
        this.processor="";
        this.ram="";
        this.graphicscard="";
        this.monitor="";
        this.os="";
        
    }
    public ComputerProduct(String name,String details,int code,float price,Image[] images,String processor,String ram,String graphicscard,String monitor,String os)
    {
        super(name,details,code,price,images);
        this.processor=processor;
        this.ram=ram;
        this.graphicscard=graphicscard;
        this.monitor=monitor;
        this.os=os;

    }
    //end constructores
    
    //setters
    public void setProcessor(String processor)
    {
        this.processor=processor;
        
    }
        public void setRam(String ram)
    {
        this.ram=ram;
        
    }
                public void setGraphicsCard(String graphicscard)
    {
        this.graphicscard=graphicscard;
        
        
    }
    public void setMonitor(String monitor)
    {
        this.monitor=monitor;
        
        
    }
    public void setOs(String os)
        {
        this.os=os;
        
        }
//end setters
                                //getters
                                public String getProcessor()
                                {
                                    return this.processor;
                                    
                                }
                                 public String getRam()
                                    {
                                    return this.ram;
                                    
                                    }
                                public String getOs()
                                 {
                                    return this.os;
                                    
                                  }
                                public String getMonitor()
                                  {
                                    return this.monitor;
                                    
                                  }
                                public String getGraphicsCard()
                                 {
                                    return this.graphicscard;
                                    
                                 }
                                //end getters
    public String toString()
   {
       String str =  super.toString();
       str = str+"Processor:"+processor + "Ram:" + ram +"Graphics Card:" + graphicscard + "Monitor:" + monitor + "OS:"  + os;      
       
       return str;
   }
}
