/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author 3oxic
 */
public class adminal {
    ArrayList<Admin> admins = new ArrayList<Admin>();
    ArrayList<NormalCustomer> ncustomers = new ArrayList<NormalCustomer>();
    ArrayList<CompanyCustomer> ccustomers = new ArrayList<CompanyCustomer>();
    //https://examples.javacodegeeks.com/core-java/util/arraylist/arraylist-in-java-example-how-to-use-arraylist/

    public adminal() {
        admins = new ArrayList<Admin>();
        ncustomers = new ArrayList<NormalCustomer>();
        ccustomers = new ArrayList<CompanyCustomer>();
    }

    public ArrayList<Admin> getAdmins() {
        return this.admins;
    }

    public ArrayList<NormalCustomer> getNcustomers() {
        return this.ncustomers;
    }

    public ArrayList<CompanyCustomer> getCcustomers() {
        return this.ccustomers;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public void setNcustomers(ArrayList<NormalCustomer> ncustomers) {
        this.ncustomers = ncustomers;
    }

    public void setCcustomers(ArrayList<CompanyCustomer> ccustomers) {
        this.ccustomers = ccustomers;
    }
    
}
