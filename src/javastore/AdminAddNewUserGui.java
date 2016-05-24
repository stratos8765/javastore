/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Giannis
 */
public class AdminAddNewUserGui extends JFrame {
    
        JPanel addadmin = new JPanel();
        
        GridBagConstraints c = new GridBagConstraints();
   public AdminAddNewUserGui()
    {
        super("Add new user");
        this.setLayout(new GridBagLayout());
        this.setVisible(true);
        this.setSize(500, 500);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx=0;
        c2.gridy=0;
        c2.weightx=1;
        c2.weighty=1;
        c2.anchor = GridBagConstraints.PAGE_START;
        addadmin.setLayout(new GridBagLayout());
        
        String[] usertypelist = new String[3];
        usertypelist[0]="Admin";
        usertypelist[1]="Normal Customer";
        usertypelist[2]="Company Customer";
        final JComboBox usertype = new JComboBox(usertypelist);
        for(int i=0;i<3;i++)
        {
        usertype.putClientProperty("usertype",usertypelist[i]);
             usertype.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    
                String usertypetext =(String) usertype.getSelectedItem();
                
                    if(usertypetext=="Admin")
                    {
                       ShowAdmin();
                    }
         
                 
                 }
              });
        }
        this.add(usertype,c2);
        c2.gridy++;
        
        this.add(addadmin,c2);
        
        
    }
public void ShowAdmin()
{

}
    
}
