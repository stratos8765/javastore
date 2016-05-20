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
public class PrinterProduct extends Product{
    private String type;
    private String papertype; // A4 A5 A...
    private String use;
    private String connection;
    //construcotrs
    public PrinterProduct()
    {
        super();
        this.type="";
        this.papertype="";
        this.use="";
        this.connection="";
        
    }
    public PrinterProduct(String name,String details,int code,float price,ArrayList<Image> images,String type,String papertype,String use,String connection)
    {
        super(name,details,code,price,images);
        this.type=type;
        this.papertype=papertype;
        this.use=use;
        this.connection=connection;
        
    }
    //end constructors
    //setters
    public void setType(String type)
    {
        this.type=type;
        
    }
    
    public void setPaperType(String papertype)
    {
        this.papertype=papertype;
        
    }
    public void setUse(String use)
    {
        this.use=use;
        
    }
    public void setConnection(String connection)
    {
        this.connection=connection;
        
    }
    //end setters
    //getters
    
    public String getType()
            {
                return this.type;
                
            }
    public String getPaperType()
    {
        return this.papertype;
        
    }
    public String getUse()
    {
        return this.use;
        
    }
    public String getConnection()
    {
        return this.connection;
        
    }
    //end getters
    public String toString()
    {
        String str="";
        str=super.toString();
        str=str+"Type:"+this.type+"\n"+"Paper Type:"+this.papertype+"\n"+"Use:"+this.use+"\n"+"Connection:"+this.connection+"\n";
        
        return str;
    }
}
