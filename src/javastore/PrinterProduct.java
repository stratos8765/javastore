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
    public PrinterProduct(String name,String details,int code,float price,Image[] images,String type,String papertype,String use,String connection)
    {
        super(name,details,code,price,images);
        this.type=type;
        this.papertype=papertype;
        this.use=use;
        this.connection=connection;
        
    }
    //end constructors
    //setters
    public void SetType(String type)
    {
        this.type=type;
        
    }
    
    public void SetPaperType(String papertype)
    {
        this.papertype=papertype;
        
    }
    public void SetUse(String use)
    {
        this.use=use;
        
    }
    public void SetConnection(String connection)
    {
        this.connection=connection;
        
    }
    //end setters
    //getters
    
    public String GetType()
            {
                return this.type;
                
            }
    public String GetPaperType()
    {
        return this.papertype;
        
    }
    public String GetUse()
    {
        return this.use;
        
    }
    public String GetConnection()
    {
        return this.connection;
        
    }
    //end getters
    public String toString()
    {
        String str="";
        str=super.toString();
        str=str+"Type:"+this.type+"Paper Type:"+this.papertype+"Use:"+this.use+"Connection:"+this.connection;
        
        return str;
    }
}
