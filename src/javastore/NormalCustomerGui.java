/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author 3oxic
 */
public class NormalCustomerGui extends JFrame {
    String customerusername ="";
    
    public NormalCustomerGui(String customer)
    {
        
        
       super("Customer Options");
       ArrayList<CameraProduct> cameraproducts = new ArrayList<CameraProduct>();
       ProductList products = new ProductList();
       products.getCameraProductsFromDB();
       
       cameraproducts = products.getCameraproducts();
       this.customerusername=customer;
       this.setVisible(true);
       this.setLayout(new GridBagLayout());
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500, 500);
       GridBagConstraints c = new GridBagConstraints();
       c.gridy=0;
       c.gridx=0;
       c.weighty = 1.0;
       c.weightx = 1.0;
       c.anchor =GridBagConstraints.FIRST_LINE_START;
        
       JLabel Computerp = new JLabel("Camera Products:");
       this.add(Computerp,c);
       
       ArrayList<JLabel> productnames = new ArrayList<JLabel>();
       c.gridy++;
       c.insets = new Insets(1,1,1,1);
       c.insets.top = 1;
       c.insets.bottom = 1;
       ArrayList<JLabel> cpdnames = new ArrayList<JLabel>();
       ArrayList<Float> cpdprices = new ArrayList<Float>();
       ArrayList<JButton> cpdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> cpdbuttonremove = new ArrayList<JButton>();
       for(int i=0;i<cameraproducts.size();i++)
       {
           c.gridx=0;
           
          JLabel pdname = new JLabel("Name: "+cameraproducts.get(i).getName());
          this.add(pdname,c);
          cpdnames.add(pdname);
          c.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(cameraproducts.get(i).getPrice()));
          this.add(pdprice,c);
          cpdprices.add(cameraproducts.get(i).getPrice());
          c.gridx++;
          JButton button = new JButton("+");
          this.add(button,c);
          cpdbuttonadd.add(button);
          c.gridx++;
          
          JButton button2 = new JButton("-");
          this.add(button2,c);
          cpdbuttonremove.add(button2);
          c.gridy++;
           
       }
 
     
c.gridx=0;
c.weightx=1;
c.weighty=1;

       
       c.anchor = GridBagConstraints.LAST_LINE_START;
       JButton logoutbutton = new JButton("Logout "+customerusername);
       this.add(logoutbutton,c);
       logoutbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               closeThis();
          
            }
       });
   c.gridx++;
   
             c.anchor= GridBagConstraints.LAST_LINE_END;
             JButton basketbutton = new JButton("Basket");
             this.add(basketbutton,c);
             basketbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
         
          
                 }
              });
             
             
             JButton ohbutton = new JButton("Order History");
             c.gridx++;
             this.add(ohbutton,c);
             basketbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
         
                 
                 }
              });
            }
    public void closeThis()
{
    super.dispose();
    
}
    }

    
