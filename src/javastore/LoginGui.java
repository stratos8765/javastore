/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author 3oxic
 */
public class LoginGui extends JFrame 
{
    
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
         String[] typeofuser = {
	 "Admin",
	 "Customer",
	 "Company Customer",
	 };
        
        JComboBox cb = new JComboBox(typeofuser);
        cb.setEditable(false);
        cb.setSelectedIndex(1);
        cb.setPreferredSize(new Dimension(90, 25));
       adminal users = new adminal();
        users.getAdminsFromDb();
        users.getCompanyCustomersFromDb();
        users.getNormalCustomersFromDb();
 
        ArrayList<NormalCustomer> ncustomers = new ArrayList<NormalCustomer>();
        ArrayList<CompanyCustomer> ccustomers = new ArrayList<CompanyCustomer>();
        
        ncustomers=users.getNcustomers();
        ccustomers=users.getCcustomers();
        
        cb.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                String s = (String) cb.getSelectedItem();//get the selected item
                if(s.equals("Admin"))
                {
              //http://stackoverflow.com/questions/12414596/how-to-check-if-a-particular-database-in-mysql-already-exists-using-java
                }
            
            }
        });   
        loginbutton.setPreferredSize(new Dimension(80, 30));
        loginbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ArrayList<Admin> admins = new ArrayList<Admin>();
                adminal users = new adminal();
                users.getAdminsFromDb();
                admins=users.getAdmins();
                
                String s = (String) cb.getSelectedItem();//get the selected item
                if(s=="Admin")
                {
                    String usernamefield=usernametext.getText();
                    String passwordfield=passwordtext.getText();
                    for (int i=0;i<admins.size();i++) {
                       String returnusername = admins.get(i).getUsername();

                       
                                
                                    
                                
                    }
                }
                
            }
            
        }
        );
        
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
        panellogin.add(cb,c);
        c.gridy++;
        panellogin.add(loginbutton,c);
   
        super.add(panellogin,BorderLayout.CENTER);
        super.setVisible(true);
        super.setSize(250, 250);
        


    }

   
   

    
}
