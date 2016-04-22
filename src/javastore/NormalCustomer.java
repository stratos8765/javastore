/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

/**
 *
 * @author 3oxic
 */
public class NormalCustomer extends Customer
{

        private String fullname;
        private int idnumber;
        private float fpa;
        
//constructors
    public NormalCustomer() 
    {
        super();
        this.fullname="";
        this.idnumber=0;
        this.fpa=23/100;
        
        
    }

    public NormalCustomer(String fullname, int idnumber, String address, int telnumber, int afm, String username, String password) {
        super(address, telnumber, afm, username, password);
        this.fullname = fullname;
        this.idnumber = idnumber;
        this.fpa=23/100;
        
    }
    //end constructors

    //setters
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }
    //end setters

    //getters
    public String getFullname() {
        return fullname;
    }

    public int getIdnumber() {
        return idnumber;
    }
    //end getters
    
    
        public String toString()
    {
        String str="";
        str=str+super.toString();
        str=str+"Full Name:"+fullname+"\n"+"Id number:"+idnumber+"\n"+"FPA:"+fpa+"\n";
        return str;
        
    }
    
    
    
        
}
