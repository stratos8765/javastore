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
public class OrderHistoryProduct {
    private int orderid;
    private String customername;
    private float totalprice;
    private String Status;
    private String address;

    public OrderHistoryProduct() {
        this.orderid=0;
        this.customername="";
        this.totalprice=0f;
        this.Status="";
        this.address="";
        
    }

    public OrderHistoryProduct(int orderid, String customername, float totalprice, String Status, String address) {
        this.orderid = orderid;
        this.customername = customername;
        this.totalprice = totalprice;
        this.Status = Status;
        this.address = address;
    }

    public int getOrderid() {
        return orderid;
    }

    public String getCustomername() {
        return customername;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public String getStatus() {
        return Status;
    }

    public String getAddress() {
        return address;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
