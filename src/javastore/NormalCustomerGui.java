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
import javax.swing.JPanel;
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
       ArrayList<ComputerProduct> computerproducts = new ArrayList<ComputerProduct>();
       
       ProductList products = new ProductList();
       products.getCameraProductsFromDB();
       products.getComputerProductsFromDB();
       computerproducts= products.getComputerproducts();
       cameraproducts = products.getCameraproducts();
       this.customerusername=customer;
       this.setVisible(true);
       this.setLayout(new GridBagLayout());
       JPanel cppanel = new JPanel();
       cppanel.setLayout(new GridBagLayout());
       GridBagConstraints c2 = new GridBagConstraints();
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500, 500);
       GridBagConstraints c = new GridBagConstraints();
       c.gridy=0;
       c.gridx=0;
       c.weighty = 1.0;
       c.weightx = 1.0;
       c.anchor =GridBagConstraints.FIRST_LINE_START;
       c2.gridy=0;
       c2.gridx=0;
       c2.weighty = 1.0;
       c2.weightx = 1.0;
       JLabel Computerp = new JLabel("Camera Products:");
       cppanel.add(Computerp,c2);
       c2.gridy++;
       ArrayList<JLabel> cpdnames = new ArrayList<JLabel>();
       ArrayList<Float> cpdprices = new ArrayList<Float>();
       ArrayList<JButton> cpdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> cpdbuttonremove = new ArrayList<JButton>();
       ArrayList<JLabel> qtys = new ArrayList<JLabel>();
        for(int i=0;i<cameraproducts.size();i++)
       {
           
           c2.gridx=0;
        JLabel pdname = new JLabel("Name: "+cameraproducts.get(i).getName());
          cppanel.add(pdname,c2);
          cpdnames.add(pdname);
          c2.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(cameraproducts.get(i).getPrice()));
          cppanel.add(pdprice,c2);
          cpdprices.add(cameraproducts.get(i).getPrice());
          c2.gridx++;
          JButton button = new JButton("+");

          cppanel.add(button,c2);
          cpdbuttonadd.add(button);
          c2.gridx++;
          
          JButton button2 = new JButton("-");
          cppanel.add(button2,c2);
          cpdbuttonremove.add(button2);
          c2.gridx++;
          JLabel qty = new JLabel("0");
          cppanel.add(qty,c2);
          qtys.add(qty);
          c2.gridy++;   
       }
        int i;
        
        for(i=0;i<cpdbuttonadd.size();i++)
        {   cpdbuttonadd.get(i).putClientProperty( "counter", i );
            cpdbuttonadd.get(i).putClientProperty( "yo", qtys);
            
            cpdbuttonadd.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ArrayList<JLabel> qt = new ArrayList<JLabel>();
               int i =(Integer)((JButton)e.getSource()).getClientProperty( "counter" );
               qt =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "yo" );
               int getvalue = Integer.parseInt(qt.get(i).getText());
               getvalue++;
               
               
               
               qt.get(i).setText(String.valueOf(getvalue));
              
          
            }

       });
        }

                for(i=0;i<cpdbuttonremove.size();i++)
        {   cpdbuttonremove.get(i).putClientProperty( "counter", i );
            cpdbuttonremove.get(i).putClientProperty( "yo", qtys);
            
            cpdbuttonremove.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ArrayList<JLabel> qt = new ArrayList<JLabel>();
               int i =(Integer)((JButton)e.getSource()).getClientProperty( "counter" );
               qt =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "yo" );
               int getvalue = Integer.parseInt(qt.get(i).getText());
               getvalue--;
               
               
               
               qt.get(i).setText(String.valueOf(getvalue));
              
          
            }

       });
        }
        
        
        this.add(cppanel,c);
        
        c.gridx++;
       JPanel computerppanel = new JPanel();
       computerppanel.setLayout(new GridBagLayout());
       c2 = new GridBagConstraints();
       
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

    
