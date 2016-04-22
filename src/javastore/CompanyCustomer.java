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
public class CompanyCustomer extends Customer
{

        private String epwnymia;
        private String ypefep;
        private int fax;
        private float fpa;
        private int discount;
        

    public CompanyCustomer() {
        super();
        this.epwnymia="";
        this.ypefep="";
        this.fax=0;
        this.fpa=0;
        this.discount=0;
        
        
    }

    public CompanyCustomer(String epwnymia, String ypefep, int fax, String address, int telnumber, int afm, String username, String password) {
        super(address, telnumber, afm, username, password);
        this.epwnymia = epwnymia;
        this.ypefep = ypefep;
        this.fax = fax;
        this.fpa=0;
        this.discount=0;
        
        
    }
//getters
    public String getEpwnymia() {
        return epwnymia;
    }

    public String getYpefep() {
        return ypefep;
    }

    public int getFax() {
        return fax;
    }

    public float getFpa() {
        return fpa;
    }

    public int getDiscount() {
        return discount;
    }
    //end getters
//setters
    public void setEpwnymia(String epwnymia) {
        this.epwnymia = epwnymia;
    }

    public void setYpefep(String ypefep) {
        this.ypefep = ypefep;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public void setFpa(float fpa) {
        this.fpa = fpa;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    //end setters
        
}
