/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 3oxic
 */
public class BasketGui extends JFrame {
    public BasketGui(String customername) throws SQLException
    {
        this.setSize(800, 500);  
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        dbmanage db = new dbmanage();
        ResultSet rs;
        
        
        rs=db.executeQuery("SELECT * FROM basket WHERE customername='"+customername+"';");
        ArrayList<JLabel> productnames = new ArrayList<JLabel>();
        ArrayList<JLabel> productprices = new ArrayList<JLabel>();
        ArrayList<JLabel> productqty = new ArrayList<JLabel>();
        ArrayList<JButton> buttonadd = new ArrayList<JButton>();
        ArrayList<JButton> buttonremove = new ArrayList<JButton>();
        ArrayList<JLabel> productlabels = new ArrayList<JLabel>();
        

        while(rs.next())
        {
            JLabel productname= new JLabel(rs.getString("pname"));
            JLabel productprice = new JLabel(String.valueOf(rs.getFloat("pprice")));
            JLabel productq = new JLabel(String.valueOf(rs.getInt("qty")));
            productnames.add(productname);
            productprices.add(productprice);
            productqty.add(productq);
         }
c.anchor = GridBagConstraints.PAGE_START;

        JPanel productspanel = new JPanel();
        productspanel.setLayout(new GridBagLayout());
        productspanel.setSize(800, 500);  
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx=0;
        c2.gridy=0;
            for(int i=0;i<productnames.size();i++)
    {
        JLabel productname = new JLabel("Product Name: " +productnames.get(i).getText());
        this.add(productname,c2);
        c2.gridx++;
        JLabel productprice = new JLabel("Product Price: " +productprices.get(i).getText());
        this.add(productprice,c2);
        c2.gridx++;
        JLabel productqtlabel = new JLabel("Amount to buy: " +productqty.get(i).getText());
        this.add(productqtlabel,c2);
        productlabels.add(productqtlabel);
        c2.gridx++;
       
        c2.gridx=0;
        c2.gridy++;
        
    }
            
    }


        
    }

