/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

import java.util.Date;

/**
 *
 * @author User
 */
public class Banco {

    private int id;
    private String type;
    private String Date;
    private double Amount;

    public Banco(int id, String type, String Date, double Amount) {
        this.id = id;
        this.type = type;
        this.Date = Date;
        this.Amount = Amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
    
            
                  
}
