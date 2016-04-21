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
public class ComputerProduct extends Product{
    //Επεξεργαστής, Μνήμη, Κάρτα Γραφικών, Οθόνη, Λειτουργικό
    private String processor;
    private String ram;
    private String graphicscard;
    private String monitor;
    private String os;
    public ComputerProduct()
    {
        super();
        this.processor="";
        this.ram="";
        this.graphicscard="";
        this.monitor="";
        this.os="";
        
    }
}
