package javastore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 3oxic
 */
public abstract class User {
    private String username;
    private String password;
//constructors
    public User() {
        this.username="";
        this.password="";
        
    }

    
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //constructors
//getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //end getters

    //setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //end setters
    
    
}
