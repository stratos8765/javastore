/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author 3oxic
 */
public class LoginGui extends JFrame 
{
    
    public static void serializeDataOut(IHandler ish)throws IOException{
    String fileName= "Test.txt";
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(ish);
    oos.close();
}
    public LoginGui() throws SQLException
    {
        super("Login");
        super.setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel usernamelabel=new JLabel("Username:");
        JLabel passwordlabel=new JLabel("Password:");
        JTextField usernametext = new JTextField(10);
        JPasswordField passwordtext = new JPasswordField(8);
        Font f1 = usernametext.getFont().deriveFont(Font.PLAIN, 10f);
        usernametext.setFont(f1);
        JPanel panellogin = new JPanel();
        JButton loginbutton = new JButton("Login");
        loginbutton.setPreferredSize(new Dimension(80, 30));
        
        panellogin.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        panellogin.add(usernamelabel,c);
        c.gridx++;
        
        panellogin.add(usernametext,c);
        c.gridx=0;
        c.gridy++;
        
        panellogin.add(passwordlabel,c);
        c.gridx++;
        
        panellogin.add(passwordtext,c);
        c.gridy++;
        
        panellogin.add(loginbutton,c);
        
        super.add(panellogin,BorderLayout.CENTER);
        super.setVisible(true);
        super.setSize(250, 250);
        String url = "jdbc:mysql://localhost:3306/test";
String username = "root";
String password = "";

System.out.println("Connecting database...");

MysqlDataSource dataSource = new MysqlDataSource();
dataSource.setUser("root");
dataSource.setPassword("");
dataSource.setServerName("localhost");
Connection conn = dataSource.getConnection();
java.sql.Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mysql.user");
        
if(rs.next()) { 
 String id = rs.getString("Host"); 
 String str1 = rs.getString("User");
 System.out.println(str1);
}
        


    }
}
