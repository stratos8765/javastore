/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.AND;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author 3oxic
 */
public class NormalCustomerGui extends JFrame {
   
    String customerusername = "";
    
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
          JLabel pdprice = new JLabel(" Price: " +String.valueOf(cameraproducts.get(i).getPrice()));
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
                
                                for(i=0;i<cpdbuttonmore.size();i++)
        {   cpdbuttonmore.get(i).putClientProperty( "cameraproduct", cameraproducts.get(i) );
            
            cpdbuttonmore.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ArrayList<JLabel> qt = new ArrayList<JLabel>();
               CameraProduct cameraproduct = new CameraProduct();
               cameraproduct = (CameraProduct)((JButton)e.getSource()).getClientProperty( "cameraproduct" );
                try {
                    MoreDetailsCameraProductGui cameraproductgui = new MoreDetailsCameraProductGui(cameraproduct);
                } catch (SQLException ex) {
                    Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
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
          for(i=0;i<computerpdbuttonmore.size();i++)
        {   computerpdbuttonmore.get(i).putClientProperty( "computerproduct", computerproducts.get(i) );
            
            computerpdbuttonmore.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ArrayList<JLabel> qt = new ArrayList<JLabel>();
               ComputerProduct computerproduct = new ComputerProduct();
               computerproduct = (ComputerProduct)((JButton)e.getSource()).getClientProperty( "computerproduct" );
                try {
                    MoreDetailsComputerProductGui cameraproductgui = new MoreDetailsComputerProductGui(computerproduct);
                } catch (SQLException ex) {
                    Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
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
        
                     for(i=0;i<laptoppdbuttonadd.size();i++)
        {   laptoppdbuttonadd.get(i).putClientProperty( "counter", i );
            laptoppdbuttonadd.get(i).putClientProperty( "yo", laptoppqtys);
            
            laptoppdbuttonadd.get(i).addActionListener(new ActionListener(){
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
     for(i=0;i<laptopdbuttonmore.size();i++)
        {   laptopdbuttonmore.get(i).putClientProperty( "laptopproduct", laptopproducts.get(i) );
            
            laptopdbuttonmore.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              
               LaptopProduct laptopproduct = new LaptopProduct();
               laptopproduct = (LaptopProduct)((JButton)e.getSource()).getClientProperty( "laptopproduct" );
                try {
                    MoreDetailsLaptopProductGui laptopdetailsgui = new MoreDetailsLaptopProductGui(laptopproduct);
                } catch (SQLException ex) {
                    Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
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
         
                     
                                          for(i=0;i<mobilepdbuttonadd.size();i++)
        {   mobilepdbuttonadd.get(i).putClientProperty( "counter", i );
            mobilepdbuttonadd.get(i).putClientProperty( "yo", mobilepqtys);
            
            mobilepdbuttonadd.get(i).addActionListener(new ActionListener(){
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
                     
                              for(i=0;i<mobilepdbuttonremove.size();i++)
        {   mobilepdbuttonremove.get(i).putClientProperty( "counter", i );
            mobilepdbuttonremove.get(i).putClientProperty( "yo", mobilepqtys);
            
            mobilepdbuttonremove.get(i).addActionListener(new ActionListener(){
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
                              
                               for(i=0;i<mobilepdbuttonmore.size();i++)
        {   mobilepdbuttonmore.get(i).putClientProperty( "mobileproduct", mobileproducts.get(i) );
            
            mobilepdbuttonmore.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              
               MobileProduct mobileproduct = new MobileProduct();
               mobileproduct = (MobileProduct)((JButton)e.getSource()).getClientProperty( "mobileproduct" );
                try {
                    MoreDetailsMobileProductGui mobiledetailsgui = new MoreDetailsMobileProductGui(mobileproduct);
                } catch (SQLException ex) {
                    Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

       });
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
                                for(i=0;i<printerpdbuttonadd.size();i++)
        {   printerpdbuttonadd.get(i).putClientProperty( "counter", i );
            printerpdbuttonadd.get(i).putClientProperty( "yo", printerpqtys);
            
            printerpdbuttonadd.get(i).addActionListener(new ActionListener(){
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
                     
                              for(i=0;i<printerpdbuttonremove.size();i++)
        {   printerpdbuttonremove.get(i).putClientProperty( "counter", i );
            printerpdbuttonremove.get(i).putClientProperty( "yo", printerpqtys);
            
            printerpdbuttonremove.get(i).addActionListener(new ActionListener(){
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
                              
                              
                                for(i=0;i<printerpdbuttonmore.size();i++)
        {   printerpdbuttonmore.get(i).putClientProperty( "printerproduct", printerproducts.get(i) );
            
            printerpdbuttonmore.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              
               PrinterProduct printerproduct = new PrinterProduct();
               printerproduct = (PrinterProduct)((JButton)e.getSource()).getClientProperty( "printerproduct" );
                try {
                    MoreDetailsPrinterProductGui printerdetailsgui = new MoreDetailsPrinterProductGui(printerproduct);
                } catch (SQLException ex) {
                    Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

       });
        }
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
                     
                                for(i=0;i<tvpdbuttonadd.size();i++)
        {   tvpdbuttonadd.get(i).putClientProperty( "counter", i );
            tvpdbuttonadd.get(i).putClientProperty( "yo", tvpqtys);
            
            tvpdbuttonadd.get(i).addActionListener(new ActionListener(){
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
                     
                              for(i=0;i<tvpdbuttonremove.size();i++)
        {   tvpdbuttonremove.get(i).putClientProperty( "counter", i );
            tvpdbuttonremove.get(i).putClientProperty( "yo", tvpqtys);
            
            tvpdbuttonremove.get(i).addActionListener(new ActionListener(){
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
                              
                               for(i=0;i<tvpdbuttonmore.size();i++)
        {   tvpdbuttonmore.get(i).putClientProperty( "tvproduct", tvproducts.get(i) );
            
            tvpdbuttonmore.get(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               
               TVProduct tvproduct = new TVProduct();
               tvproduct = (TVProduct)((JButton)e.getSource()).getClientProperty( "tvproduct" );
                try {
                    MoreDetailsTVProductGui tvproductgui = new MoreDetailsTVProductGui(tvproduct);
                } catch (SQLException ex) {
                    Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

       });
        }
                     

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
       JButton addtobbutton = new JButton("Add to Basket");
       c.gridx++;
          addtobbutton.putClientProperty( "CameraProductNames", cpdnames );
            addtobbutton.putClientProperty( "CameraProductQtys", qtys);
            
            addtobbutton.putClientProperty("ComputerProductNames",computerpdnames);
            addtobbutton.putClientProperty("ComputerProductQtys",computerpqtys);

            addtobbutton.putClientProperty("LaptopProductNames",laptoppdnames);
            addtobbutton.putClientProperty("LaptopProductQtys",laptoppqtys);
            
            addtobbutton.putClientProperty("MobileProductNames",mobilepdnames);
            addtobbutton.putClientProperty("MobileProductQtys",mobilepqtys);
            
            addtobbutton.putClientProperty("PrinterProductNames",printerpdnames);
            addtobbutton.putClientProperty("PrinterProductQtys",printerpqtys);
            
            addtobbutton.putClientProperty("TVProductNames",tvpdnames);
            addtobbutton.putClientProperty("TVProductQtys",tvpqtys);
            
            addtobbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ArrayList<JLabel> camerapqtys = new ArrayList<JLabel>();
               ArrayList<JLabel> computerpqtys = new ArrayList<JLabel>();
               ArrayList<JLabel> laptoppqtys = new ArrayList<JLabel>();
               ArrayList<JLabel> mobilepqtys = new ArrayList<JLabel>();
               ArrayList<JLabel> printerpqtys = new ArrayList<JLabel>();
               ArrayList<JLabel> tvpqtys = new ArrayList<JLabel>();
               ArrayList<JLabel> camerapdnames = new ArrayList<JLabel>();
               ArrayList<JLabel> computernames = new ArrayList<JLabel>();
               ArrayList<JLabel> laptopnames = new ArrayList<JLabel>();
               ArrayList<JLabel> mobilenames = new ArrayList<JLabel>();
               ArrayList<JLabel> printernames = new ArrayList<JLabel>();
               ArrayList<JLabel> tvnames = new ArrayList<JLabel>();
               
               //int i =(Integer)((JButton)e.getSource()).getClientProperty( "counter" );
               
               camerapqtys =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "CameraProductQtys" );
               computerpqtys=(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "ComputerProductQtys" );
               laptoppqtys=(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "LaptopProductQtys" );
               mobilepqtys=(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "MobileProductQtys" );
               printerpqtys=(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "PrinterProductQtys" );
               tvpqtys=(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "TVProductQtys" );
              
               camerapdnames = (ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "CameraProductNames" );
               computernames =(ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "ComputerProductNames" );
               laptopnames = (ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "LaptopProductNames" );
               mobilenames = (ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "MobileProductNames" );
               printernames = (ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "PrinterProductNames" );
               tvnames = (ArrayList<JLabel>)((JButton)e.getSource()).getClientProperty( "TVProductNames" );
              dbmanage productmanage = new dbmanage();
              for(int i =0;i<camerapqtys.size();i++)
              {
                  if(Integer.parseInt(camerapqtys.get(i).getText())>=0)
                  {
                      String[] arraypdname = camerapdnames.get(i).getText().split("\\: ", -1);
                  ResultSet rs;
                  int rs2;
                  
                  dbmanage db2 = new dbmanage();
                  
                  rs =productmanage.executeQuery("SELECT * FROM productqtys WHERE name='"+arraypdname[1]+"'");
                      try {
                          while(rs.next())
                          {
                              int availableqty=rs.getInt("availableqty");
                              if(availableqty>=Integer.parseInt(camerapqtys.get(i).getText()) && Integer.parseInt(camerapqtys.get(i).getText())!=0)
                              {
                                  int newavailableqty=availableqty -(Integer.parseInt(camerapqtys.get(i).getText()));
                                  //System.out.println("UPDATE productqtys SET availableqty="+newavailableqty+" WHERE name='"+arraypdname[1]+"'");
                                  
                                  rs2=db2.executeUpdate("UPDATE productqtys SET availableqty="+newavailableqty+" WHERE name='"+arraypdname[1]+"'");
                                          
                              }
                              else if(Integer.parseInt(camerapqtys.get(i).getText())!=0)
                              {
                                  JFrame error = new JFrame();
                                  JOptionPane.showMessageDialog(error, "You can only buy  "+availableqty+" Pieces Of product: "+arraypdname[1]);
                              }
                          }                     } catch (SQLException ex) {
                          Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                  
                          
              }
             
              
                for(int i =0;i<computerpqtys.size();i++)
              {
                  if(Integer.parseInt(computerpqtys.get(i).getText())>=0)
                  {
                      String[] arraypdname = computernames.get(i).getText().split("\\: ", -1);
                  ResultSet rs;
                  
                  rs =productmanage.executeQuery("SELECT * FROM productqtys WHERE name='"+arraypdname[1]+"'");
                      try {
                          while(rs.next())
                          {
                              int availableqty=rs.getInt("availableqty");
                              if(availableqty>=Integer.parseInt(computerpqtys.get(i).getText()))
                              {
                                  
                              }
                              else
                              {
                                  JFrame error = new JFrame();
                                  JOptionPane.showMessageDialog(error, "You can only buy  "+availableqty+" Pieces Of product: "+arraypdname[1]);
                              }
                          }                     } catch (SQLException ex) {
                          Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                  
                          
              }
                
                
                for(int i =0;i<laptoppqtys.size();i++)
              {
                  if(Integer.parseInt(laptoppqtys.get(i).getText())>=0)
                  {
                      String[] arraypdname = laptopnames.get(i).getText().split("\\: ", -1);
                  ResultSet rs;
                  
                  rs =productmanage.executeQuery("SELECT * FROM productqtys WHERE name='"+arraypdname[1]+"'");
                      try {
                          while(rs.next())
                          {
                              int availableqty=rs.getInt("availableqty");
                              if(availableqty>=Integer.parseInt(laptoppqtys.get(i).getText()))
                              {
                                  
                              }
                              else
                              {
                                  JFrame error = new JFrame();
                                  JOptionPane.showMessageDialog(error, "You can only buy  "+availableqty+" Pieces Of product: "+arraypdname[1]);
                              }
                          }                     } catch (SQLException ex) {
                          Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                  
                          
              }

                                for(int i =0;i<mobilepqtys.size();i++)
              {
                  if(Integer.parseInt(mobilepqtys.get(i).getText())>=0)
                  {
                      String[] arraypdname = mobilenames.get(i).getText().split("\\: ", -1);
                  ResultSet rs;
                  
                  rs =productmanage.executeQuery("SELECT * FROM productqtys WHERE name='"+arraypdname[1]+"'");
                  
                      try {
                          while(rs.next())
                          {
                              int availableqty=rs.getInt("availableqty");
                              if(availableqty>=Integer.parseInt(mobilepqtys.get(i).getText()))
                              {
                                  
                              }
                              else
                              {
                                  JFrame error = new JFrame();
                                  JOptionPane.showMessageDialog(error, "You can only buy  "+availableqty+" Pieces Of product: "+arraypdname[1]);
                              }
                          }                     } catch (SQLException ex) {
                          Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                  
                          
              }
                                
                                for(int i =0;i<printerpqtys.size();i++)
              {
                  if(Integer.parseInt(printerpqtys.get(i).getText())>=0)
                  {
                      String[] arraypdname = printernames.get(i).getText().split("\\: ", -1);
                  ResultSet rs;
                  
                  rs =productmanage.executeQuery("SELECT * FROM productqtys WHERE name='"+arraypdname[1]+"'");
                  
                      try {
                          while(rs.next())
                          {
                              int availableqty=rs.getInt("availableqty");
                              if(availableqty>=Integer.parseInt(printerpqtys.get(i).getText()))
                              {
                                  
                              }
                              else
                              {
                                  JFrame error = new JFrame();
                                  JOptionPane.showMessageDialog(error, "You can only buy  "+availableqty+" Pieces Of product: "+arraypdname[1]);
                              }
                          }                     } catch (SQLException ex) {
                          Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                  
                          
              }
                                
                                for(int i =0;i<tvpqtys.size();i++)
              {
                  if(Integer.parseInt(tvpqtys.get(i).getText())>0)
                  {
                      String[] arraypdname = tvnames.get(i).getText().split("\\: ", -1);
                  ResultSet rs;
                  
                  rs =productmanage.executeQuery("SELECT * FROM productqtys WHERE name='"+arraypdname[1]+"'");
                  
                      try {
                          while(rs.next())
                          {
                              int availableqty=rs.getInt("availableqty");
                              if(availableqty>=Integer.parseInt(tvpqtys.get(i).getText()))
                              {
                                  
                              }
                              else
                              {
                                  JFrame error = new JFrame();
                                  JOptionPane.showMessageDialog(error, "You can only buy  "+availableqty+" Pieces Of product: "+arraypdname[1]);
                              }
                          }                     } catch (SQLException ex) {
                          Logger.getLogger(NormalCustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                  
                          
              }
               
            }

       });
       this.add(addtobbutton,c);
             //c.anchor= GridBagConstraints.PAGE_END;
            c.gridx++;
            
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
