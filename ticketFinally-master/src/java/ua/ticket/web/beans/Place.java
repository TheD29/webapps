/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "Place", urlPatterns = {"/Place"})
public class Place {
    
    private int id;
    private int row;
    private int number;
    private int idSector;
    private String PIP;
    private int status;
    private int price;
    public List<Integer> sizeRow = new ArrayList<Integer>();
    public List<Integer> sizePlaces = new ArrayList<Integer>();
    
    public Place(){
        
    }
    
    public Place(int id, int row, int number, int idSector, String PIP, int status, int price){
        this.id = id;
        this.row = row;
        this.number = number;
        this.idSector = idSector;
        this.PIP = PIP;
        this.status = status;
        this.price = price;
        
    }
    
    public int getId(){
        return id;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getIdSector(){
        return idSector;
    }
    
    public String getPIP(){
        return PIP;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setId(int id){
        this.id = id; 
    }
    
    public void setRow(int row){
        this.row = row; 
    }
    
    public void setNumber(int number){
        this.number = number; 
    }
    
    public void setIdSector(int idSector){
        this.idSector = idSector; 
    }
    
    public void setPIP(String PIP){
        this.PIP = PIP;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public int getSizeRow(){
        return sizeRow.size();
    }
    
    public int getSizePlaces(){
        return sizePlaces.size();
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    @Override
    public boolean equals(Object place){
        if (place instanceof Place){
            if (((Place)place).getId() == this.id 
                 && ((Place)place).getIdSector() == this.idSector
                 && ((Place)place).getRow() == this.row
                 && ((Place)place).getNumber() == this.number){
                return true;
            } else {
                return false;
            }
        }else { 
            return false;
        }
    }
    
    public boolean hashCode(Place place){
        if(place.id == this.id){
            return true;
        }else {
            return false;
        }
    }
}
