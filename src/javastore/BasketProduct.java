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
public class BasketProduct {
    String ProductName;
    int qty;
    String CustomerName;
    float price;
    int ProductCode;
    public BasketProduct()
    {
        this.CustomerName="";
        this.ProductName="";
        this.qty=0;
        this.price=0;
        this.ProductCode=0;
        
        
        
    }
    
        public BasketProduct(String CustomerName,int ProductCode,String ProductName,int qty,float price)
    {
        this.CustomerName=CustomerName;
        this.ProductName=ProductName;
        this.qty=qty;
        this.price=price;
        this.ProductCode=0;
        
    }


    public String getProductName() {
        return ProductName;
    }

    public int getQty() {
        return qty;
    }
    
    
    public int getProductCode() {
        return ProductCode;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public float getPrice() {
        return price;
    }


    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    
   public void setPrice(float price) {
        this.price = price;
    }
   public void setProductCode(int ProductCode) {
        this.ProductCode = ProductCode;
    }
    
        
}
