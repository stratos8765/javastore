/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public LoginGui()
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
        
        
         Admin[] admins = new Admin[10];
         Admin admin1 = new Admin("3oxic","stefan8765");
         admins[0]=admin1;
         try{
             
    
         FileOutputStream out = new FileOutputStream("test.txt");
         ObjectOutputStream oout = new ObjectOutputStream(out);

         // write something in the file
         oout.writeObject(admins[0].toString()+"\n"+"============");
            oout.close();
          ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream("test.txt"));

         // read and print what we wrote before
         System.out.println("" + (String) ois.readObject());
         System.out.println("" + ois.readObject());

         }
         catch(Exception ex)
         {
          
         }
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   
            }
        });
        
    }
}
