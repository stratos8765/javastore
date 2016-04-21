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
   public void SetGreen(int green)
   {
       this.green=green;
       
   }
      public void SetRed(int red)
   {
       this.red=red;
       
   }
         public void SetBlue(int blue)
   {
       this.blue=blue;
       
   }
         //end setters
         //getters
  public int GetGreen()
  {
      return this.green;
      
  }
    public int GetBlue()
  {
      return this.blue;
      
  }
      public int GetRed()
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
