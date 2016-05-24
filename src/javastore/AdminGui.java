/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author 3oxic
 */
public class AdminGui extends JFrame {
    public AdminGui(String username)
    {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setSize(400, 400);
        GridBagConstraints c= new GridBagConstraints();
        c.gridy=0;
        c.gridx=0;
        c.weightx=1;
        c.weighty=1;
        
        JButton adduser = new JButton("Add user");
        
        
        this.add(adduser,c);
        
        c.gridy++;
        JButton edituser = new JButton("Edit/Delete User");
        this.add(edituser,c);
        
        c.gridy++;
        JButton showproducts = new JButton("Show Products");
        this.add(showproducts,c);
        
        c.gridy++;
        
        JButton editproduct = new JButton("Edit/Delete Products");
        this.add(editproduct,c);
        
        c.gridy++;
        JButton updateorderstatus = new JButton("Update Order Status");
        this.add(updateorderstatus,c);
        
        c.gridy++;
        JButton showcustomers = new JButton("Show Customers");
        this.add(showcustomers,c);
        
        c.gridy++;
        JButton showorderspuser = new JButton("Show orders by user");
        this.add(showorderspuser,c);
        
        c.gridy++;
        JButton totalsum = new JButton("Incomes");
        this.add(totalsum,c);
        
    }
}
