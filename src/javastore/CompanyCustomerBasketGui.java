/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static sun.management.Agent.error;

/**
 *
 * @author 3oxic
 */
public class CompanyCustomerBasketGui extends JFrame {
    public CompanyCustomerBasketGui(String customername) throws SQLException
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
        JLabel productqtlabel = new JLabel("  Amount to buy: " +productqty.get(i).getText());
        this.add(productqtlabel,c2);
        productlabels.add(productqtlabel);
        JButton removebutton = new JButton("Remove");
                removebutton.putClientProperty( "cname", customername);
                removebutton.putClientProperty("pname",productnames.get(i).getText());
                removebutton.putClientProperty("pqty",productqty.get(i).getText());
                
             removebutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    String cname=(String)((JButton)e.getSource()).getClientProperty( "cname" );
                    String pname=(String)((JButton)e.getSource()).getClientProperty( "pname" );
                    String pqty=(String)((JButton)e.getSource()).getClientProperty( "pqty" );
                    dbmanage conn = new dbmanage();
                    int rs;
                    int getqty;
                    try {
                        rs=conn.executeUpdate("DELETE FROM basket WHERE pname='"+pname+"' AND qty="+Integer.parseInt(pqty)+" limit 1;"); 
                        rs=conn.executeUpdate("UPDATE productqtys SET availableqty = availableqty + "+pqty+" WHERE name='"+pname+"';");
                        JFrame error = new JFrame();
                        JOptionPane.showMessageDialog(error, "Product Removed!");
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(CompanyCustomerBasketGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                 }
              });
             c2.gridx++;
             
             
             this.add(removebutton,c2);

        c2.gridx=0;
        c2.gridy++;
        
    }
            
            float totalprice=0;
           
          c2.gridy++;
          
          for(int i=0;i<productprices.size();i++)
          {
              totalprice=totalprice+((Float.parseFloat(productprices.get(i).getText()))*(Integer.parseInt(productqty.get(i).getText())));
             
          }
          dbmanage conn2 = new dbmanage();
          ResultSet rs2;
          rs2=conn2.executeQuery("SELECT * FROM ccustomers WHERE username='"+customername+"';");
          float discountprice=9999;
          int discount=0;
          float discountvalue;
          while(rs2.next())
          {
              discountprice=rs2.getFloat("nprice");
              discount=rs2.getInt("discount");
          }
          if(totalprice > discountprice)
          {
              discountvalue=discount/(100.0f);
              totalprice=(totalprice-(totalprice*discountvalue));
              
          }
      
          
          JLabel totalpricelabel = new JLabel("Total Price(With Fees): "+totalprice +" Euro");


          String[] addresses = new String[20];
          dbmanage conn = new dbmanage();
          ResultSet rsadd;
          
          rsadd=conn.executeQuery("SELECT * FROM ccustomers WHERE username='"+customername+"'");
          int i=0;
            while(rsadd.next())
            {
                 addresses[i]=rsadd.getString("address");
                 i++;
                 
            }
            rsadd=conn.executeQuery("SELECT * FROM addresses WHERE name='"+customername+"';");
             while(rsadd.next())
            {
                 addresses[i]=rsadd.getString("address");
                 i++;
                 
            }
             addresses[i]="Add new address";
            JLabel salabel = new JLabel("Select Address:");
            this.add(salabel,c2);
            c2.gridx++;
            final JComboBox cb = new JComboBox(addresses);
             cb.putClientProperty("cname",customername);
             cb.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    String address = (String) cb.getSelectedItem();
                    if(address=="Add new address")
                    {
                      String customername=(String)((JComboBox)e.getSource()).getClientProperty( "cname" );
                      AddNewAddressGui adgui = new AddNewAddressGui(customername);
                      closethis();
                      
                        
                    }
         
                 
                 }
              });
            this.add(cb,c2);
            c2.gridy++;
            c2.gridx=1;
            
            
            
            
           totalpricelabel.setFont(new Font(totalpricelabel.getName(), Font.PLAIN, 14));

            this.add(totalpricelabel,c2);
          c2.gridy++;
              JButton confirmorderbutton = new JButton("Confirm Order");
              
              confirmorderbutton.putClientProperty("cname",customername);
              confirmorderbutton.putClientProperty("pnames",productnames);
              confirmorderbutton.putClientProperty("pprices",productprices);
              confirmorderbutton.putClientProperty("pqtys",productqty);
              confirmorderbutton.putClientProperty("tprice",totalprice);
            //confirmorderbutton.putClientProperty( "yo", tvpqtys);
            confirmorderbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String cname =(String)((JButton)e.getSource()).getClientProperty( "cname" );
                float totalprice=(float)((JButton)e.getSource()).getClientProperty( "tprice" );
                String address = (String) cb.getSelectedItem();
                ArrayList<JLabel> pnames =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "pnames" );
                ArrayList<JLabel> pprices =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "pprices" );
                ArrayList<JLabel> pqtys =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "pqtys" );
                dbmanage conn = new dbmanage();
                ResultSet rs;
                int rs2;
                
               rs=conn.executeQuery("SELECT * FROM orders");
               int orderid=0;
               
                try {
                    while(rs.next())
                    {
                        orderid++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CompanyCustomerBasketGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
              for(int i=0;i<pnames.size();i++)
              {
                    try {
                        rs2=conn.executeUpdate("INSERT INTO orderdetails(OrderId, pname, pprice, pqty) VALUES("+orderid+",'"+pnames.get(i).getText()+"',"+Float.parseFloat(pprices.get(i).getText())+","+Integer.parseInt(pqtys.get(i).getText())+");");
                    } catch (SQLException ex) {
                        Logger.getLogger(CompanyCustomerBasketGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
              }
                try {
                    rs2=conn.executeUpdate("INSERT INTO orders(OrderId, cname, totalprice, status, address) VALUES("+orderid+",'"+cname+"',"+totalprice+",'Order Placed','"+address+"');");
                } catch (SQLException ex) {
                    Logger.getLogger(CompanyCustomerBasketGui.class.getName()).log(Level.SEVERE, null, ex);
                }
          JFrame error = new JFrame();
          JOptionPane.showMessageDialog(error, "Order Placed Succesfully!");
          JOptionPane.showMessageDialog(error, "Order Number is:"+orderid);
                try {
                    rs2=conn.executeUpdate("DELETE FROM basket WHERE customername='"+cname+"';");
                } catch (SQLException ex) {
                    Logger.getLogger(CompanyCustomerBasketGui.class.getName()).log(Level.SEVERE, null, ex);
                }
          
            }
            

       });
          this.add(confirmorderbutton,c2);          
    }

    
         public void closethis()
         {
             this.dispose();
             
         }

        
    }

