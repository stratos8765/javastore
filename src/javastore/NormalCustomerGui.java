/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.*;


/**
 *
 * @author 3oxic
 */
public class NormalCustomerGui extends JFrame {
    public NormalCustomerGui()
    {
       super("Customer Options");
       this.setVisible(true);
       this.setLayout(new BorderLayout());
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500, 500);
    }
    
}
