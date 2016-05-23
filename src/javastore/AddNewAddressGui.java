/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author 3oxic
 */
public class AddNewAddressGui extends JFrame {
    public AddNewAddressGui(String customername)
    {
        this.setLayout(new GridBagLayout());
        this.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        this.setSize(300, 200);
        c.gridx=0;
        c.gridy=0;
        c.weightx=1;
        c.weighty=1;
        
        JLabel addlabel = new JLabel("Enter new Address:");
        this.add(addlabel,c);
        JTextField address = new JTextField();
        c.gridx++;
        this.add(address,c);
        c.gridx=0;
        c.gridy++;
        JButton enteraddress = new JButton("Submit");
        this.add(enteraddress,c);
        //name = username_field.getText();
        enteraddress.putClientProperty("cname", customername);
        enteraddress.putClientProperty("address", address);
        enteraddress.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    String cname=(String)((JButton)e.getSource()).getClientProperty( "cname" );
                    JTextField addresstext =(JTextField)((JButton)e.getSource()).getClientProperty( "address" );
                    String address = addresstext.getText();
                    dbmanage conn = new dbmanage();
                    int rs;
                    try {
                        rs=conn.executeUpdate("INSERT INTO addresses(name,address) VALUES('"+cname+"','"+address+"';");
                    } catch (SQLException ex) {
                        Logger.getLogger(AddNewAddressGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    closethis();
                    try {
                        NormalCustomerBasketGui bgui = new NormalCustomerBasketGui(cname);
                    } catch (SQLException ex) {
                        Logger.getLogger(AddNewAddressGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
         
                 
                 }
              });
    }
    public void closethis()
    {
        this.dispose();
        
    }
}
