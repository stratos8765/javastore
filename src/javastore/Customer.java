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
public abstract class Customer extends User
{
private String address;
private int telnumber;
private int afm;

//constructors
    public Customer() 
    {
        super();
        this.address="";
        this.telnumber=0;
        this.afm=0;
        
    }

    public Customer(String address, int telnumber, int afm, String username, String password) {
        super(username, password);
        this.address = address;
        this.telnumber = telnumber;
        this.afm = afm;
    }
//setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelnumber(int telnumber) {
        this.telnumber = telnumber;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }
//getters
    public String getAddress() {
        return address;
    }

    public int getTelnumber() {
        return telnumber;
    }

    public int getAfm() {
        return afm;
    }
    
    
    public String toString()
    {
        String str="";
        str=str+super.toString();
        str=str+"Address:"+address+"Telephone Number:"+telnumber+"AFM:"+afm;
        return str;
        
    }

}
