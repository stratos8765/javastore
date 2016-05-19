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
       ArrayList<LaptopProduct> laptopproducts = new ArrayList<LaptopProduct>();
       ArrayList<MobileProduct> mobileproducts = new ArrayList<MobileProduct>();
       ArrayList<PrinterProduct> printerproducts = new ArrayList<PrinterProduct>();
       ArrayList<TVProduct> tvproducts = new ArrayList<TVProduct>();
       
       
       ProductList products = new ProductList();
       products.getCameraProductsFromDB();
       products.getComputerProductsFromDB();
       products.getLaptopProductsFromDB();
       products.getMobileProductsFromDB();
       products.getPrinterProductsFromDB();
       products.getTVProductsFromDB();
       
       computerproducts= products.getComputerproducts();
       cameraproducts = products.getCameraproducts();
       laptopproducts = products.getLaptopproducts();
       mobileproducts = products.getMobileproducts();
       printerproducts = products.getPrinterproducts();
       tvproducts = products.getTvproducts();
       
       
       this.customerusername=customer;
       this.setVisible(true);
       this.setLayout(new GridBagLayout());
       JPanel cppanel = new JPanel();
       cppanel.setLayout(new GridBagLayout());
       GridBagConstraints c2 = new GridBagConstraints();
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1200, 700);
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
       ArrayList<JButton> cpdbuttonmore = new ArrayList<JButton>();
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
          c2.gridx++;
          JButton morebutton = new JButton("More Details");
          cppanel.add(morebutton,c2);
          cpdbuttonmore.add(morebutton);
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
                JLabel computerproductslabel = new JLabel("Computer Products :");
                
                c2=new GridBagConstraints();
                //computerproducts
                ArrayList<JLabel> computerpdnames = new ArrayList<JLabel>();
       ArrayList<Float> computerpdprices = new ArrayList<Float>();
       ArrayList<JButton> computerpdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> computerpdbuttonremove = new ArrayList<JButton>();
       ArrayList<JButton> computerpdbuttonmore = new ArrayList<JButton>();
       ArrayList<JLabel> computerpqtys = new ArrayList<JLabel>();
       
             computerppanel.add(computerproductslabel,c2);
             c2.gridy++;
             c2.gridy++;
                     for( i=0;i<computerproducts.size();i++)
       {
           
           c2.gridx=0;
        JLabel pdname = new JLabel("Name: "+computerproducts.get(i).getName());
          computerppanel.add(pdname,c2);
          computerpdnames.add(pdname);
          c2.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(computerproducts.get(i).getPrice()));
          computerppanel.add(pdprice,c2);
          computerpdprices.add(computerproducts.get(i).getPrice());
          c2.gridx++;
          JButton button = new JButton("+");

          computerppanel.add(button,c2);
          computerpdbuttonadd.add(button);
          c2.gridx++;
          
          JButton button2 = new JButton("-");
          computerppanel.add(button2,c2);
          computerpdbuttonremove.add(button2);
          c2.gridx++;
          JLabel qty = new JLabel("0");
          computerppanel.add(qty,c2);
          computerpqtys.add(qty);
          c2.gridx++;
          JButton morebutton = new JButton("More Details");
          computerppanel.add(morebutton,c2);
          computerpdbuttonmore.add(morebutton);
          c2.gridy++;   
       }
                     
                     
                     for(i=0;i<computerpdbuttonadd.size();i++)
        {   computerpdbuttonadd.get(i).putClientProperty( "counter", i );
            computerpdbuttonadd.get(i).putClientProperty( "yo", computerpqtys);
            
            computerpdbuttonadd.get(i).addActionListener(new ActionListener(){
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
                     
                              for(i=0;i<computerpdbuttonremove.size();i++)
        {   computerpdbuttonremove.get(i).putClientProperty( "counter", i );
            computerpdbuttonremove.get(i).putClientProperty( "yo", computerpqtys);
            
            computerpdbuttonremove.get(i).addActionListener(new ActionListener(){
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
                     this.add(computerppanel,c);
                     c.gridx++;
                     
                     
                     JPanel laptopproductspanel = new JPanel();
                     laptopproductspanel.setLayout(new GridBagLayout());
                     c2= new GridBagConstraints();
                     c2.gridy=0;
                     c2.gridx=0;
                     
                     JLabel laptopproductslabel = new JLabel("Laptop Products :");
                     laptopproductspanel.add(laptopproductslabel,c2);
                    
                     ArrayList<JLabel> laptoppdnames = new ArrayList<JLabel>();
       ArrayList<Float> laptoppdprices = new ArrayList<Float>();
       ArrayList<JButton> laptoppdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> laptoppdbuttonremove = new ArrayList<JButton>();
       ArrayList<JButton> laptopdbuttonmore = new ArrayList<JButton>();
       ArrayList<JLabel> laptoppqtys = new ArrayList<JLabel>();
       
       c2.gridy++;
       
        for( i=0;i<laptopproducts.size();i++)
       {
           
           c2.gridx=0;
        JLabel pdname = new JLabel("Name: "+laptopproducts.get(i).getName());
          laptopproductspanel.add(pdname,c2);
          laptoppdnames.add(pdname);
          c2.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(laptopproducts.get(i).getPrice()));
          laptopproductspanel.add(pdprice,c2);
          laptoppdprices.add(laptopproducts.get(i).getPrice());
          c2.gridx++;
          JButton button = new JButton("+");

          laptopproductspanel.add(button,c2);
          laptoppdbuttonadd.add(button);
          c2.gridx++;
          
          JButton button2 = new JButton("-");
          laptopproductspanel.add(button2,c2);
          laptoppdbuttonremove.add(button2);
          c2.gridx++;
          JLabel qty = new JLabel("0");
          laptopproductspanel.add(qty,c2);
          laptoppqtys.add(qty);
          c2.gridx++;
          JButton morebutton = new JButton("More Details");
          laptopproductspanel.add(morebutton,c2);
          laptopdbuttonmore.add(morebutton);
          c2.gridy++;   
       }
        
         for(i=0;i<laptoppdbuttonremove.size();i++)
        {   laptoppdbuttonremove.get(i).putClientProperty( "counter", i );
            laptoppdbuttonremove.get(i).putClientProperty( "yo", laptoppqtys);
            
            laptoppdbuttonremove.get(i).addActionListener(new ActionListener(){
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
        this.add(laptopproductspanel,c);
        JPanel mobileproductspanel = new JPanel();
        mobileproductspanel.setLayout(new GridBagLayout());
        c2 = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx=0;
        ArrayList<JLabel> mobilepdnames = new ArrayList<JLabel>();
       ArrayList<Float> mobilepdprices = new ArrayList<Float>();
       ArrayList<JButton> mobilepdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> mobilepdbuttonremove = new ArrayList<JButton>();
       ArrayList<JButton> mobilepdbuttonmore = new ArrayList<JButton>();
       ArrayList<JLabel> mobilepqtys = new ArrayList<JLabel>();
       JLabel mobileproductslabel = new JLabel("Mobile Products :");
             mobileproductspanel.add(mobileproductslabel,c2);
             c2.gridy++;
             c2.gridy++;
                     for( i=0;i<mobileproducts.size();i++)
       {
           
           c2.gridx=0;
        JLabel pdname = new JLabel("Name: "+mobileproducts.get(i).getName());
          mobileproductspanel.add(pdname,c2);
          mobilepdnames.add(pdname);
          c2.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(mobileproducts.get(i).getPrice()));
          mobileproductspanel.add(pdprice,c2);
          mobilepdprices.add(mobileproducts.get(i).getPrice());
          c2.gridx++;
          JButton button = new JButton("+");

          mobileproductspanel.add(button,c2);
           mobilepdbuttonadd.add(button);
          c2.gridx++;
          
          JButton button2 = new JButton("-");
          mobileproductspanel.add(button2,c2);
          mobilepdbuttonremove.add(button2);
          c2.gridx++;
          JLabel qty = new JLabel("0");
          mobileproductspanel.add(qty,c2);
          mobilepqtys.add(qty);
          c2.gridx++;
          JButton morebutton = new JButton("More Details");
          mobileproductspanel.add(morebutton,c2);
          mobilepdbuttonmore.add(morebutton);
          c2.gridy++;   
       }
                     this.add(mobileproductspanel,c);
      
       
       
               JPanel printerproductspanel = new JPanel();
        printerproductspanel.setLayout(new GridBagLayout());
        c2 = new GridBagConstraints();
        
        ArrayList<JLabel> printerpdnames = new ArrayList<JLabel>();
       ArrayList<Float> printerpdprices = new ArrayList<Float>();
       ArrayList<JButton> printerpdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> printerpdbuttonremove = new ArrayList<JButton>();
       ArrayList<JButton> printerpdbuttonmore = new ArrayList<JButton>();
       ArrayList<JLabel> printerpqtys = new ArrayList<JLabel>();
       JLabel printerproductslabel = new JLabel("Printer Products :");
       
             printerproductspanel.add(printerproductslabel,c2);
             c2.gridy++;
             c2.gridy++;
                     for( i=0;i<printerproducts.size();i++)
       {
           
           c2.gridx=0;
        JLabel pdname = new JLabel("Name: "+printerproducts.get(i).getName());
          printerproductspanel.add(pdname,c2);
          printerpdnames.add(pdname);
          c2.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(printerproducts.get(i).getPrice()));
          printerproductspanel.add(pdprice,c2);
          printerpdprices.add(printerproducts.get(i).getPrice());
          c2.gridx++;
          JButton button = new JButton("+");

          printerproductspanel.add(button,c2);
           printerpdbuttonadd.add(button);
          c2.gridx++;
          
          JButton button2 = new JButton("-");
          printerproductspanel.add(button2,c2);
          printerpdbuttonremove.add(button2);
          c2.gridx++;
          JLabel qty = new JLabel("0");
          printerproductspanel.add(qty,c2);
          printerpqtys.add(qty);
          c2.gridx++;
          JButton morebutton = new JButton("More Details");
          printerproductspanel.add(morebutton,c2);
          printerpdbuttonmore.add(morebutton);
          c2.gridy++;   
       }
                     c.gridx++;
                     this.add(printerproductspanel,c);
                     

                                   JPanel tvproductspanel = new JPanel();
        tvproductspanel.setLayout(new GridBagLayout());
        c2 = new GridBagConstraints();
        
        ArrayList<JLabel> tvpdnames = new ArrayList<JLabel>();
       ArrayList<Float> tvpdprices = new ArrayList<Float>();
       ArrayList<JButton> tvpdbuttonadd = new ArrayList<JButton>();
       ArrayList<JButton> tvpdbuttonremove = new ArrayList<JButton>();
       ArrayList<JButton> tvpdbuttonmore = new ArrayList<JButton>();
       ArrayList<JLabel> tvpqtys = new ArrayList<JLabel>();
       JLabel tvproductslabel = new JLabel("TV Products :");
       
             tvproductspanel.add(tvproductslabel,c2);
             c2.gridy++;
             c2.gridy++;
                     for( i=0;i<tvproducts.size();i++)
       {
           
           c2.gridx=0;
        JLabel pdname = new JLabel("Name: "+tvproducts.get(i).getName());
          tvproductspanel.add(pdname,c2);
          tvpdnames.add(pdname);
          c2.gridx++;
          JLabel pdprice = new JLabel("Price: " +String.valueOf(tvproducts.get(i).getPrice()));
          tvproductspanel.add(pdprice,c2);
          tvpdprices.add(tvproducts.get(i).getPrice());
          c2.gridx++;
          JButton button = new JButton("+");

          tvproductspanel.add(button,c2);
           tvpdbuttonadd.add(button);
          c2.gridx++;
          
          JButton button2 = new JButton("-");
          tvproductspanel.add(button2,c2);
          tvpdbuttonremove.add(button2);
          c2.gridx++;
          JLabel qty = new JLabel("0");
          tvproductspanel.add(qty,c2);
          tvpqtys.add(qty);
          c2.gridx++;
          JButton morebutton = new JButton("More Details");
          tvproductspanel.add(morebutton,c2);
          tvpdbuttonmore.add(morebutton);
          c2.gridy++;   
       }
                     c.gridx++;
                     this.add(tvproductspanel,c);

c.weightx=1;
c.weighty=1;

  c.anchor = GridBagConstraints.LAST_LINE_START;
  c.gridy=0;
  c.gridx=0;
  
       JButton logoutbutton = new JButton("Logout "+customerusername);
       this.add(logoutbutton,c);
       logoutbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               closeThis();
          
            }
       });
             c.anchor= GridBagConstraints.PAGE_END;
             JButton basketbutton = new JButton("Basket");
             this.add(basketbutton,c);
             basketbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
         
          
                 }
              });
             
             c.anchor= GridBagConstraints.LAST_LINE_END;
             JButton ohbutton = new JButton("Order History");
            // c.gridx++;
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
