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

    public CompanyCustomer() {
        super();
        this.epwnymia="";
        this.ypefep="";
        this.fax=0;
        
    }

    public CompanyCustomer(String epwnymia, String ypefep, int fax, String address, int telnumber, int afm, String username, String password) {
        super(address, telnumber, afm, username, password);
        this.epwnymia = epwnymia;
        this.ypefep = ypefep;
        this.fax = fax;
    }
    
        
}
