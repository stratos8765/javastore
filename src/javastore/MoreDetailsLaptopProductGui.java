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
public class MoreDetailsLaptopProductGui extends JFrame {
    public MoreDetailsLaptopProductGui(LaptopProduct laptopproduct) throws SQLException
    {
     this.setSize(750, 500);  
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        LaptopProduct product = new LaptopProduct();
        product=laptopproduct;
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
        JLabel processorlabel = new JLabel("Proccessor: ");
        this.add(processorlabel,c);
        c.gridx++;
       JLabel processor = new JLabel(product.getProcessor());
       this.add(processor,c);
       c.gridx--;
       c.gridy++;
       JLabel ramlabel = new JLabel("Ram: ");
       this.add(ramlabel,c);
       c.gridx++;
       JLabel ram = new JLabel(product.getRam());
       this.add(ram,c);
       
       c.gridx--;
       c.gridy++;
       JLabel graphicscardlabel = new JLabel("Graphics Card:");
       this.add(graphicscardlabel,c);
       c.gridx++;
       JLabel graphicscard = new JLabel(product.getGraphicsCard());
       this.add(graphicscard,c);
       c.gridx--;
       c.gridy++;
       JLabel ssdlabel = new JLabel("SSD :");
       this.add(ssdlabel,c);
       c.gridx++;
       JLabel ssd = new JLabel(product.getSsd());
       this.add(ssd,c);
       c.gridy++;
       c.gridx--;
       JLabel cdromlabel = new JLabel("CD Rom: ");
       this.add(cdromlabel,c);
       c.gridx++;
       JLabel cdrom = new JLabel(product.getCdrom());
       this.add(cdrom,c);
       
       
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

