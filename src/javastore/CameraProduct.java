/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.Image;

/**
 *
 * @author 3oxic
 */
public class CameraProduct extends Product {
 private int megapixels;
 private int iso;
 private int exposure;
 private int fps;
 //constructos 
 public CameraProduct()
 {
     super();
     this.megapixels=0;
     this.iso=0;
     this.exposure=0;
     this.fps=0;
     
 }
 public CameraProduct(String name,String details,int code,float price,Image[] images,int megapixels,int iso,int exposure,int fps)
 {
  super(name,details,code,price,images);
  this.megapixels=megapixels;
  this.iso=iso;
  this.exposure=exposure;
  this.fps=fps;
  
 }
 //end constructors
 //setters
 public void SetMegaPixels(int megapixels)
 {
     this.megapixels=megapixels;
     
 }
 public void SetIso(int iso)
 {
     this.iso=iso;
     
 }
 public void SetExposure(int exposure)
 {
     this.exposure=exposure;
     
 }
 public void SetFps(int fps)
 {
     this.fps=fps;
     
 }
 //end Setters
 //getters

 public int GetMexaPixels()
 {
     return this.megapixels;
     
 }
 public int GetIso()
 {
     return this.iso;
     
 }
 public int GetExposure()
 {
     return this.exposure;
     
 }
 public int GetFps()
 {
     return this.fps;
     
 }
 //end getters
 public String toString()
 {
    String str= super.toString();
    str=str+"Megapixels:"+megapixels+"ISO:"+iso+"Exposure:"+exposure+"FPS:"+fps;
    
    return str;
    
 }
}