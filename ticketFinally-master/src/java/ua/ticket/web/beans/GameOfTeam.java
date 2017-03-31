/*
Creator : us9546
07.07.2016
*/
package ua.ticket.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class GameOfTeam {
    
    private int id;
    private String nameTeam1;
    private String nameTeam2;
    private String dateGame;
    private String timeGame;
    private String placeGame;
    private String season;

    public void setSeason(String season) {
        this.season = season;
    }



 // getters and setters
    public String getSeason() {
        return season;
    }
    public int getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getTimeGame(){
        return timeGame;
    }
    public void setTimeGame(String timeGame){
        this.timeGame = timeGame;
    }
    
    public String getNameTeam1() {
        return nameTeam1;
    }
    public void setNameTeam1(String nameTeam1) {
        this.nameTeam1 = nameTeam1;
    }

    public String getNameTeam2() {
        return nameTeam2;
    }

    public void setNameTeam2(String nameTeam2) {
        this.nameTeam2 = nameTeam2;
    }

    public String getDateGame() {
        return dateGame;
    }

    public void setDateGame(String dateGame) {
        this.dateGame = dateGame;
    }

    public String getPlaceGame() {
        return placeGame;
    }

    public void setPlaceGame(String placeGame) {
        this.placeGame = placeGame;
    }
}
