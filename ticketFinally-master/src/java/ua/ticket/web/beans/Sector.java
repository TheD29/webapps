/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.beans;

/**
 *
 * @author us9522
 */
public class Sector {
    
    private int id;
    private String name;
    private int price;
    
    public Sector(){
        
    }
    
    public Sector(int id, String name, int prise){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    
}
