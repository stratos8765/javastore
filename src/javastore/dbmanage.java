package javastore;

import java.sql.*;

public class dbmanage {
   // JDBC driver name and database URL
   private String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private String DB_URL = "jdbc:mysql://localhost/javaproject4291";

   //  Database credentials
   private String USER = "java";
   private String PASS = "4291";
   private ResultSet rs;
   Connection conn;
   Statement stmt;
   public dbmanage() {
  
   try{
       
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
   }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }
  
}
   public ResultSet executeQuery(String sqlquery)
   {
      boolean result=false;
      
      try
      {
       
      rs = stmt.executeQuery(sqlquery);
      result=true;
      
      
      }
      catch(SQLException ex)
      {
         ex.printStackTrace(); 
      }
      return rs;
      
   }
   public boolean getResult()
   {
    boolean result=false;
    
    try
    {
        while(rs.next()){
         String first = rs.getString("username"); 
         System.out.print("Username: " + first+"\n"); 
         result=true;
         
      }
    }
    catch(SQLException ex)
      {
         ex.printStackTrace(); 
      }   catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
    return result;
   }
   public boolean closeConnection()
   {
       boolean result=false;
       
       try{
            rs.close();
      stmt.close();
      conn.close(); 
      result=true;
      
       }
       catch(Exception ex)
      {
         ex.printStackTrace(); 
      }
       return result;
       
   }
}//end FirstExample