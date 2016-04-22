/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

/**
 *
 * @author 3oxic
 */
public class Color {
    private int red;
    private int green;
    private int blue;
    private String str;
    
   public Color() 
   {
       this.red=0;
       this.green=0;
       this.blue=0;
       
   }
   public Color(int red,int green,int blue)
   {
   this.red=red;
   this.green=green;
   this.blue=blue;
   
   }
   //setters
   public void setGreen(int green)
   {
       this.green=green;
       
   }
      public void setRed(int red)
   {
       this.red=red;
       
   }
         public void setBlue(int blue)
   {
       this.blue=blue;
       
   }
         //end setters
         //getters
  public int getGreen()
  {
      return this.green;
      
  }
    public int getBlue()
  {
      return this.blue;
      
  }
      public int getRed()
  {
      return this.red;
      
  }
      //end getters
      
      public String toString()
      {
       str="Red:"+red+"Green:"+green+"Blue:"+blue;
       return str;
       
      }
   
}
