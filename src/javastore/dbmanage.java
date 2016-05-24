package javastore;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.*;

public class dbmanage {
   // JDBC driver name and database URL
   private String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private String DB_URL = "jdbc:mysql://localhost/javaproject";

   //  Database credentials
   private String USER = "root";
   private String PASS = "";
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
   public int executeUpdate(String sqlquery) throws SQLException
   {
       int result;
       result = stmt.executeUpdate(sqlquery);
       return result;
   }
   //testing.
   
   public PreparedStatement ps() throws SQLException
   {
       String sql = "";
       
       PreparedStatement preparedStatement = conn.prepareStatement(sql);
       preparedStatement.setString(1, "Test");
preparedStatement.setString(2, "Test2");
preparedStatement.setString(3, "Test3");
preparedStatement.executeUpdate(); 
    return preparedStatement;
    
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

    ResultSet exequteQuery(java.lang.String select__from_ccustomers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end FirstExample