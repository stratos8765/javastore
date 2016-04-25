/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 3oxic
 */
public class adminal {
    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<NormalCustomer> ncustomers = new ArrayList<NormalCustomer>();
    private ArrayList<CompanyCustomer> ccustomers = new ArrayList<CompanyCustomer>();
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
    
    
     public void getAdminsFromDb() {
        dbmanage db = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM Admin");

        try
    {
        while(rs.next()){
            Admin administrator = new Admin();
            administrator.setUsername(rs.getString("username"));
            administrator.setPassword(rs.getString("password"));
            this.admins.add(administrator);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
     }
     
     
         public void getNormalCustomersFromDb() {
        dbmanage db = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM ncustomers");

        try
    {
        while(rs.next()){
            NormalCustomer ncustomer = new NormalCustomer();
            ncustomer.setUsername(rs.getString("username"));
            ncustomer.setPassword(rs.getString("password"));
            ncustomer.setAddress(rs.getString("address"));
            ncustomer.setTelnumber(rs.getInt("telnumber"));
            ncustomer.setAfm(rs.getInt("afm"));
            ncustomer.setFullname(rs.getString("fullname"));
            ncustomer.setIdnumber(rs.getInt("idnumber"));
            
            this.ncustomers.add(ncustomer);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
     
         
         public void getCompanyCustomersFromDb() {
        dbmanage db = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM ccustomers");

        try
    {
        while(rs.next()){
            CompanyCustomer ccustomer = new CompanyCustomer();
            ccustomer.setUsername(rs.getString("username"));
            ccustomer.setPassword(rs.getString("password"));
            ccustomer.setAfm(rs.getInt("afm"));
            ccustomer.setFax(rs.getInt("fax"));
            ccustomer.setTelnumber(rs.getInt("telnumber"));
            ccustomer.setDiscount(rs.getInt("discount"));
            ccustomer.setFpa(0);
            ccustomer.setAddress(rs.getString("address"));
            ccustomer.setEpwnymia(rs.getString("epwnymia"));
            ccustomer.setYpefep(rs.getString("ypefep"));
                       
            this.ccustomers.add(ccustomer);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
   
     }
