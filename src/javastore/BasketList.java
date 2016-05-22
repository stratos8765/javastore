/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.util.ArrayList;

/**
 *
 * @author 3oxic
 */
public class BasketList {
    ArrayList<BasketProduct> bproducts = new ArrayList<BasketProduct>();
    
    
    public BasketList()
    {
       bproducts= new ArrayList<BasketProduct>();
       
    }
        public BasketList(ArrayList<BasketProduct> bproducts)
    {
       this.bproducts= bproducts;
       
    }

    public ArrayList<BasketProduct> getBproducts() {
        return bproducts;
    }

    public void setBproducts(ArrayList<BasketProduct> bproducts) {
        this.bproducts = bproducts;
    }
        
        
}
