/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 3oxic
 */
public class Admin extends User
{

    
    public Admin() {
        super.setUsername("");
        super.setPassword("");
        
    }
    public Admin(String username, String password) {
        super(username, password);
    }

}


