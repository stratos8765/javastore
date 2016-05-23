/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 3oxic
 */
public class OrderHistoryGui extends JFrame{
    public OrderHistoryGui(String CustomerName) throws SQLException
    {
        ArrayList<OrderHistoryProduct> orders = new ArrayList<OrderHistoryProduct>();
        dbmanage conn = new dbmanage();
        ResultSet rs;
        
        rs=conn.executeQuery("SELECT * FROM orders WHERE cname='"+CustomerName+"';");
        
        while(rs.next())
        {
            OrderHistoryProduct oh = new OrderHistoryProduct();
            oh.setAddress(rs.getString("address"));
            oh.setOrderid(rs.getInt("OrderId"));
            oh.setStatus(rs.getString("status"));
            oh.setTotalprice(rs.getFloat("totalprice"));
            oh.setCustomername(rs.getString("cname"));
            orders.add(oh);           
        }
       this.setVisible(true);
       this.setLayout(new GridBagLayout());
        this.setSize(800, 500);
       JPanel cppanel = new JPanel();
       cppanel.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.gridy=0;
       c.gridx=0;
       c.weightx=1;
       c.weighty=1;
       c.anchor = GridBagConstraints.PAGE_START;
       for(int i=0;i<orders.size();i++)
       {
           JLabel oidlabel = new JLabel("OrderId: " + orders.get(i).getOrderid());
           c.gridx++;
           this.add(oidlabel,c);
           
           JLabel tplabel = new JLabel("Total Price: " + orders.get(i).getTotalprice());
           c.gridx++;
           this.add(tplabel,c);
           
           JLabel addlabel = new JLabel("Address: " + orders.get(i).getAddress());
           c.gridx++;
           this.add(addlabel,c);
           
           JLabel stlabel = new JLabel("Status :" + orders.get(i).getStatus());
           c.gridx++;
           this.add(stlabel,c);
           c.gridy++;
           c.gridx=0;
           
       }
       
    }
    
}
