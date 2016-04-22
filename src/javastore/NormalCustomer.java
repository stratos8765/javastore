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
//constructors
    public NormalCustomer() 
    {
        super();
        this.fullname="";
        this.idnumber=0;
        
    }

    public NormalCustomer(String fullname, int idnumber, String address, int telnumber, int afm, String username, String password) {
        super(address, telnumber, afm, username, password);
        this.fullname = fullname;
        this.idnumber = idnumber;
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
    
    
    
    
    
    
        
}
