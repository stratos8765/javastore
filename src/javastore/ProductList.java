/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author 3oxic
 */
public class ProductList {
    private ArrayList<ComputerProduct> computerproducts = new ArrayList<ComputerProduct>();
    private ArrayList<CameraProduct> cameraproducts = new ArrayList<CameraProduct>();
    private ArrayList<LaptopProduct> laptopproducts = new ArrayList<LaptopProduct>();
    private ArrayList<MobileProduct> mobileproducts = new ArrayList<MobileProduct>();
    private ArrayList<PrinterProduct> printerproducts= new ArrayList<PrinterProduct>();
    private ArrayList<TVProduct> tvproducts = new ArrayList<TVProduct>();
    
    
    public void getComputerProductsFromDB() {
        dbmanage db = new dbmanage();
        dbmanage db2 = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM computerproducts ORDER BY name");
       ArrayList<Image> images = new ArrayList<Image>();
        try
    {
        while(rs.next()){
            ComputerProduct cp = new ComputerProduct();

           cp.setName(rs.getString("name"));
            cp.setDetails(rs.getString("details"));
            cp.setCode(rs.getInt("code"));
            cp.setPrice(rs.getFloat("price"));
            cp.setProcessor(rs.getString("processor"));
            cp.setRam(rs.getString("ram"));
            cp.setGraphicsCard(rs.getString("graphicscard"));
            cp.setMonitor(rs.getString("monitor"));
            cp.setOs(rs.getString("os"));
                         
            this.computerproducts.add(cp);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
    
    
    
    
    public void getCameraProductsFromDB() {
        dbmanage db = new dbmanage();
        dbmanage db2 = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM cameraproducts ORDER BY name");
       ArrayList<Image> images = new ArrayList<Image>();
       
        try
    {
        while(rs.next()){
            
            CameraProduct cp = new CameraProduct();
            
            cp.setName(rs.getString("name"));
            cp.setDetails(rs.getString("details"));
            cp.setCode(rs.getInt("code"));
            cp.setPrice(rs.getFloat("price"));
            cp.setMegaPixels(rs.getInt("megapixels"));
            cp.setIso(rs.getInt("iso"));
            cp.setExposure(rs.getInt("exposure"));
            cp.setFps(rs.getInt("fps"));
                       
            this.cameraproducts.add(cp);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
    
    
    public void getLaptopProductsFromDB() {
        dbmanage db = new dbmanage();
        dbmanage db2 = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM laptopproducts ORDER BY name");
       ArrayList<Image> images = new ArrayList<Image>();
       
        try
    {
        
        while(rs.next()){
            LaptopProduct cp = new LaptopProduct();

            cp.setName(rs.getString("name"));
            cp.setDetails(rs.getString("details"));
            cp.setCode(rs.getInt("code"));
            cp.setPrice(rs.getFloat("price"));
            cp.setProcessor(rs.getString("processor"));
            cp.setRam(rs.getString("ram"));
            cp.setGraphicsCard(rs.getString("graphicscard"));
            cp.setSsd(rs.getString("ssd"));
            cp.setCdrom(rs.getString("cdrom"));
            ResultSet rs2;
                        rs2=db2.executeQuery("SELECT * FROM productimages WHERE name='"+rs.getString("name")+"'");
            
                    
                               
            this.laptopproducts.add(cp);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
    
        public void getMobileProductsFromDB() {
        dbmanage db = new dbmanage();
        dbmanage db2 = new dbmanage();
        ResultSet rs;
        ArrayList<Image> images = new ArrayList<Image>();
        
       rs=db.executeQuery("SELECT * FROM mobileproducts ORDER BY name");

        try
    {
        while(rs.next()){
            MobileProduct cp = new MobileProduct();

           cp.setName(rs.getString("name"));
            cp.setDetails(rs.getString("details"));
            cp.setCode(rs.getInt("code"));
            cp.setPrice(rs.getFloat("price"));
            cp.setProcessor(rs.getString("processor"));
            cp.setOs(rs.getString("os"));
            cp.setMonitor(rs.getString("monitor"));
            cp.setCamera(rs.getString("camera"));
            cp.setWifi(rs.getString("wifi"));
            cp.setColour(rs.getString("colour"));  
            ResultSet rs2;
                        rs2=db2.executeQuery("SELECT * FROM productimages WHERE name='"+rs.getString("name")+"'");
            
                       
            this.mobileproducts.add(cp);
            
      
         
         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
                public void getPrinterProductsFromDB() {
        dbmanage db = new dbmanage();
        dbmanage db2 = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM printerproducts ORDER BY name");
ArrayList<Image> images = new ArrayList<Image>();
        try
    {
        while(rs.next()){
            PrinterProduct cp = new PrinterProduct();
            
            
           cp.setName(rs.getString("name"));
            cp.setDetails(rs.getString("details"));
            cp.setCode(rs.getInt("code"));
            cp.setPrice(rs.getFloat("price"));
            cp.setType(rs.getString("type"));
            cp.setPaperType(rs.getString("papertype"));
            cp.setConnection(rs.getString("connection"));
            cp.setUse(rs.getString("use")); 
                ResultSet rs2;
                        rs2=db2.executeQuery("SELECT * FROM productimages WHERE name='"+rs.getString("name")+"'");
            
                        while(rs2.next())
            {
                 
            byte[] img = rs2.getBytes("Image");

                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    images.add(newImage.getImage());
            
            }
            cp.setImages(images);
                 images.clear();
                 
            this.printerproducts.add(cp);

         
      }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }
                
                
    public void getTVProductsFromDB() {
        dbmanage db = new dbmanage();
        dbmanage db2 = new dbmanage();
        ResultSet rs;
       rs=db.executeQuery("SELECT * FROM tvproducts ORDER BY name");
       ArrayList<Image> images = new ArrayList<Image>();
       
        try
    {
        while(rs.next()){
            TVProduct cp = new TVProduct();
            
           cp.setName(rs.getString("name"));
            cp.setDetails(rs.getString("details"));
            cp.setCode(rs.getInt("code"));
            cp.setPrice(rs.getFloat("price"));
            cp.setInches(rs.getInt("inches"));
            cp.setHd(rs.getString("hd"));
            
            ResultSet rs2;
                        rs2=db2.executeQuery("SELECT * FROM productimages WHERE name='"+rs.getString("name")+"'");
            images= new ArrayList<Image>();
            
                        while(rs2.next())
            {
                 
            byte[] img = rs2.getBytes("Image");

                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    images.add(newImage.getImage());
            
            }
            cp.setImages(images);
            images.clear();
            
            
            this.tvproducts.add(cp);

         
  
        }
    }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
        db.closeConnection();
        
     }

    public ProductList() {

        this.cameraproducts = new ArrayList<CameraProduct>();
        this.computerproducts = new ArrayList<ComputerProduct>();
        this.mobileproducts = new ArrayList<MobileProduct>();
        this.tvproducts = new ArrayList<TVProduct>();
        this.laptopproducts = new ArrayList<LaptopProduct>();
        
    }

    public ArrayList<ComputerProduct> getComputerproducts() {
        return computerproducts;
    }

    public ArrayList<CameraProduct> getCameraproducts() {
        return cameraproducts;
    }

    public ArrayList<LaptopProduct> getLaptopproducts() {
        return laptopproducts;
    }

    public ArrayList<MobileProduct> getMobileproducts() {
        return mobileproducts;
    }

    public ArrayList<PrinterProduct> getPrinterproducts() {
        return printerproducts;
    }

    public ArrayList<TVProduct> getTvproducts() {
        return tvproducts;
    }

    public void setComputerproducts(ArrayList<ComputerProduct> computerproducts) {
        this.computerproducts = computerproducts;
    }

    public void setCameraproducts(ArrayList<CameraProduct> cameraproducts) {
        this.cameraproducts = cameraproducts;
    }

    public void setLaptopproducts(ArrayList<LaptopProduct> laptopproducts) {
        this.laptopproducts = laptopproducts;
    }

    public void setMobileproducts(ArrayList<MobileProduct> mobileproducts) {
        this.mobileproducts = mobileproducts;
    }

    public void setPrinterproducts(ArrayList<PrinterProduct> printerproducts) {
        this.printerproducts = printerproducts;
    }

    public void setTvproducts(ArrayList<TVProduct> tvproducts) {
        this.tvproducts = tvproducts;
    }
    
    
    
    
}
