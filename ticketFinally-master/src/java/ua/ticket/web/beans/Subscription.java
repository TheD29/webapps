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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author us9522
 */
@ManagedBean
@SessionScoped
public class Subscription {
    public Subscription(){
        
    }
    
    private int id;
    private String PIP;
    private String season;
    private String sector;
    private int row;
    private int number;
    
    public Subscription(int id, String PIP, String season, int placeId){
        this.id = id;
        this.PIP = PIP;
        this.season = season;
        //this.placeId = placeId;
    }
    
    public Subscription(int id, String PIP, String season, String sector, int row, int number){
        this.id = id;
        this.PIP = PIP;
        this.season = season;
        this.sector = sector;
        this.row = row;
        this.number = number;
        //this.aPlace = aPlace;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getPIP(){
        return PIP;
    }
    
    public void setPIP(String PIP){
        this.PIP = PIP;
    }
    
    public String getSeason(){
        return season;
    }
    
    public void setSeason(String season){
        this.season = season;
    }
    
    public String getSector(){
        return sector;
    }
    
    public void setSector(String sector){
        this.sector = sector;
    }
    
    public int getRow(){
        return row;
    }
    
    public void setRow(int row){
        this.row = row;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
}
