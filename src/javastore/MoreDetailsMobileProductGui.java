/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 3oxic
 */
public class MoreDetailsMobileProductGui extends JFrame {
    public MoreDetailsMobileProductGui(MobileProduct mobileproduct) throws SQLException
    {
        this.setSize(750, 500);  
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        MobileProduct product = new MobileProduct();
        product=mobileproduct;
        c.gridx=0;
        c.gridy=0;
        c.weightx=1;
        c.weighty=1;
        c.anchor = GridBagConstraints.PAGE_START;
        JLabel productnamelabel = new JLabel("Product Name: ");
        this.add(productnamelabel,c);
        c.gridx++;
        JLabel productname = new JLabel(product.getName());
        this.add(productname,c);
        c.gridy++;
        c.gridx--;
        JLabel productinfolabel = new JLabel("Product info: ");
        this.add(productinfolabel,c);
        JLabel productinfo = new JLabel(product.getDetails());
        c.gridx++;
        this.add(productinfo,c);
        c.gridy++;
        c.gridx--;
        JLabel productcodelabel = new JLabel("Product Code: ");
        this.add(productcodelabel,c);
        c.gridx++;
        JLabel productcode = new JLabel(Integer.toString(product.getCode()));
        this.add(productcode,c);
        c.gridy++;
        c.gridx--;
        JLabel pricelabel = new JLabel("Price :");
        this.add(pricelabel,c);
        c.gridx++;
        JLabel price = new JLabel(String.valueOf(product.getPrice())+" Euro");
        this.add(price,c);
        c.gridy++;
        c.gridx--;
        JLabel cameralabel = new JLabel("Camera: ");
        this.add(cameralabel,c);
        c.gridx++;
        JLabel camera = new JLabel(product.getCamera());
        this.add(camera,c);
        c.gridy++;
        c.gridx--;
        JLabel colourlabel = new JLabel("Colour: ");
        this.add(colourlabel,c);
        c.gridx++;
        JLabel colour = new JLabel(product.getColour());
        this.add(colour,c);
        c.gridy++;
        c.gridx--;
        JLabel proccessorlabel = new JLabel("Proccessor: ");
        this.add(proccessorlabel,c);
        c.gridx++;
        JLabel proccessor = new JLabel(product.getProcessor());
        this.add(proccessor,c);
        c.gridy++;
        c.gridx--;
        JLabel monitorlabel = new JLabel("Monitor: ");
        this.add(monitorlabel,c);
        c.gridx++;
       JLabel monitor = new JLabel(product.getMonitor());
       this.add(monitor,c);
      c.gridy++;
      c.gridx--;
      
       JLabel wifilabel = new JLabel("Wifi Adaptor: ");
      this.add(wifilabel,c);
      c.gridx++;
      JLabel wifi = new JLabel(product.getWifi());
      this.add(wifi,c);
      
      
      JPanel imagespanel = new JPanel();
        imagespanel.setLayout(new GridLayout(1, 5));
        dbmanage db = new dbmanage();
        ResultSet rs2;
        rs2=db.executeQuery("SELECT * FROM productimages WHERE name='"+product.getName()+"'");
        ArrayList<Image> images = new ArrayList<Image>();

         while(rs2.next())
            {
                 
            byte[] img = rs2.getBytes("Image");

                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    images.add(newImage.getImage());
            
            }

                    
        for(int i =0 ;i < images.size();i++)
        {
              ImageIcon newImage = new ImageIcon(images.get(i));
              JLabel productimage = new JLabel(newImage);
              imagespanel.add(productimage);
              
              
        }
       
  
        c.anchor=GridBagConstraints.LINE_START;
        c.gridx=0;
        c.gridy++;
        //c.gridy++;
        this.add(imagespanel,c);
        
    }
}
