/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.ticket.web.db.Database;

/**
 *
 * @author us9546
 */
@WebServlet(name = "ReportController", urlPatterns = {"/ReportController"})
public class ReportController extends HttpServlet {
    
    /**
     *
     */
    public static ArrayList<Integer>arrPlace = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,SQLException{
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader( "Content-disposition", "inline; filename=ALVList.html" );
        response.setHeader( "Cache-control", "" );
        response.setHeader( "Pragma", "" );
        request.setCharacterEncoding("UTF-8");
        super.service(request, response); //To change body of generated methods, choose Tools | Templates.
    }
    
      
    
    
    public String getNameSector(int idSector){
        String result = "";
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;
            

            String getSector = "SELECT tickets.sector.name "
                              + "FROM tickets.sector "
                              + "join tickets.ticket_on_game "
                              + "on tickets.sector.id = " + idSector;
            
            rs = stmt.executeQuery(getSector);
            while(rs.next()){
                result = rs.getString("name");
            } 
            return result;
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return result;
    } 
    
    
    
    public LinkedHashSet geIDtSectorsForReport(int gameId){
        
        LinkedHashSet<String> arrSector = new LinkedHashSet<String>(); 
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            String getSector =  " SELECT ts.name" 
                                + " FROM tickets.ticket_on_game tg" 
                                + " left join tickets.sector ts on"
                                + " ts.id = tg.id_sector"
                                + " where tg.id_game = " + gameId
                                + " order by name";
            rs = stmt.executeQuery(getSector);
            while (rs.next()) {
                arrSector.add(rs.getString("name"));
            }

    }   catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SectorController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        return arrSector;
        }
    
    }
    
    
    public LinkedHashSet getSectorsForReport(int gameId){
        
        LinkedHashSet<Integer> arrSector = new LinkedHashSet<Integer>(); 
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            String getSector =  "SELECT id_sector FROM tickets.ticket_on_game where id_game = " + gameId + " group by id_sector";
            rs = stmt.executeQuery(getSector);
            while (rs.next()) {
                arrSector.add(Integer.parseInt(rs.getString("id_sector")));
            }

    }   catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SectorController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        return arrSector;
        }
    
    }
    
    public String getNameSectorForReport(int idSector){
        String result = "";
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;

            String getSector = "SELECT tickets.sector.name "
                              + "FROM tickets.sector "
                              + "join tickets.ticket_on_game "
                              + "on tickets.sector.id = " + idSector;
            
            rs = stmt.executeQuery(getSector);
            while(rs.next()){
                result = rs.getString("name");
            } 
            //return result;
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return result;
    } 
    
    
    public void getSizePlaceForReport(int idSector, int idGame){

        if (arrPlace.size()>0){
            arrPlace.clear();
        }
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;
            arrPlace.clear();
            
            String getPlace = " SELECT tg.number"
                    + " FROM tickets.ticket_on_game tg"
                    + " left join tickets.sector ts on tg.id_sector = ts.id "
                    + " where ts.id = " + idSector + " and "
                    + " tg.id_game = " + idGame
                    + " and (status = 1)";
            
            rs = stmt.executeQuery(getPlace);
            while(rs.next()){
                int place = (rs.getInt("number"));
                arrPlace.add(place);                
            }

        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getPriceSectorForReport(int idSector){
        int price = 0;
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;
            arrPlace.clear();
            
            String getPrice = " SELECT price FROM tickets.sector where id = " + idSector;
            
            rs = stmt.executeQuery(getPrice);
            while(rs.next()){
                 price = Integer.parseInt(rs.getString("price"));
                              
            } 
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return price;
    }
  
}