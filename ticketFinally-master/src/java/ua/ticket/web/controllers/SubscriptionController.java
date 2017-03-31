/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.controllers;

/**
 *
 * @author us9522
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.ticket.web.beans.Subscription;
import ua.ticket.web.db.Database;

/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "SubscriptionController", urlPatterns = {"/SubscriptionController"})
public class SubscriptionController extends HttpServlet{
        
    private ArrayList<Subscription> subscriptionsList = new ArrayList<Subscription>();

    private ArrayList<Subscription> getSubscription(String str) {
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Subscription subscription = new Subscription();
                subscription.setId(rs.getInt("id"));
                subscription.setPIP(rs.getString("PIP"));
                subscription.setSeason(rs.getString("season"));
                subscription.setSector(rs.getString("name"));
                subscription.setRow(rs.getInt("row"));
                subscription.setNumber(rs.getInt("number"));
                subscriptionsList.add(subscription);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return subscriptionsList;
    }

    public ArrayList<Subscription> getSubscriptionAll() {
        if (!subscriptionsList.isEmpty()) {
            return subscriptionsList;
        } else {
            String sql = "SELECT subscription.id, PIP, season, place.row, place.number, sector.name "
                                    +"FROM tickets.subscription "
                                    +"join tickets.place on "
                                    +"subscription.placeId = place.id "
                                    +"join sector on place.idSector = sector.id";
            //System.out.println(sql);
            return getSubscription(sql);
        }
    }
    public ArrayList<Subscription> getCountSubscription(){
        if (!subscriptionsList.isEmpty()) {
            return subscriptionsList;
        } else {
            return getSubscription("select count(1) from subscription ");
        }
    }
    
    protected void updateSubscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String id = request.getParameter("id");
        String PIP = request.getParameter("PIP");
        String season = request.getParameter("season");
        String sector = request.getParameter("sector");
        String row = request.getParameter("row");
        String number = request.getParameter("number");
        
        System.out.println("method update");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "update tickets.subscription "
                    + "set PIP = '" + PIP
                    + "', season = '" + season
                    + "', placeId = ( "
                    + "select place.id  from place join sector on place.idSector = sector.id  "
                    + "where row =  " + row
                    + " and number =  " + number
                    + " and sector.name = '" + sector
                    + "') "
                    + " where id=" + id;
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            response.sendRedirect("pages/sub.jsp");
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void addSubscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String PIP = request.getParameter("PIP");
        String season = request.getParameter("season");
        String sector = request.getParameter("sectors");
        String row = request.getParameter("rows");
        String number = request.getParameter("number");
        ResultSet rs = null;

        System.out.println("method add");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "INSERT INTO tickets.subscription "
                    + "(PIP, season) "
                    + "VALUES"
                    + "('" + PIP 
                    + "','" + season
                    + "');";
            
            String sqlMax = "select max(id) as id from tickets.subscription";
            String id = "";
            
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            rs = stmt.executeQuery(sqlMax);
            while(rs.next()){
                id = rs.getString("id");
            }
            rs.close();
            
            String sqlSec = "update tickets.subscription "
                    + "set placeId = ( "
                    + "select place.id  from place join sector on place.idSector = sector.id  "
                    + "where row =  " + row
                    + " and number =  " + number
                    + " and sector.name = '" + sector
                    + "') "
                    + "where id = " + id;
            
            
            stmt.executeUpdate(sqlSec);
            
            String updateStatusSupscrip = "update tickets.ticket_on_game"
                        + " join tickets.place"
                        + " on  tickets.ticket_on_game.row = tickets.place.row"
                        + " and tickets.ticket_on_game.number    = tickets.place.number"
                        + " and tickets.ticket_on_game.id_sector = tickets.place.idSector"
                        + " join tickets.subscription on tickets.place.id = tickets.subscription.placeId"
                        + " join  tickets.games on tickets.games.season =  tickets.subscription.season"
                        + " and tickets.games.id = tickets.ticket_on_game.id_game"
                        + " set tickets.ticket_on_game.status = 2, tickets.ticket_on_game.PIP = tickets.subscription.PIP"
                        + " where  tickets.subscription.id = (SELECT max(id) FROM subscription)"
                        + " and tickets.games.date >= curdate()";
            
            stmt.executeUpdate(updateStatusSupscrip);
            //System.out.println(updateStatusSupscrip);
            response.sendRedirect("pages/sub.jsp");
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void deleteSubscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        //System.out.println("method delete");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            String sqlUpdateGame = "update tickets.ticket_on_game"
                    + " join tickets.place on  tickets.ticket_on_game.row = tickets.place.row"
                    + " and tickets.ticket_on_game.number    = tickets.place.number"
                    + " and tickets.ticket_on_game.id_sector = tickets.place.idSector"
                    + " join tickets.subscription on  tickets.subscription.id = " + id
                    + " and tickets.place.id = tickets.subscription.placeId"
                    + "	set tickets.ticket_on_game.status = 0,"
                    + " tickets.ticket_on_game.PIP = ' '";
            System.out.println(sqlUpdateGame);
            stmt.executeUpdate(sqlUpdateGame);
            
            String sql = "delete from tickets.subscription "
                    + " where id=" + id;
            
            stmt.executeUpdate(sql);
            System.out.println(sql);
            
            response.sendRedirect("pages/sub.jsp");
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void sub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            response.sendRedirect("pages/sub.jsp");
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedHashSet getNameSectorsInGame(){
        LinkedHashSet<String> listSectors = new LinkedHashSet<String>();
        String result = "";
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;
            

            String getSector = "SELECT tickets.sector.name "
                              + "FROM tickets.sector "
                              + "join tickets.ticket_on_game "
                              + "on tickets.sector.id = tickets.ticket_on_game.id_sector";
            
            System.out.println(getSector);
            rs = stmt.executeQuery(getSector);
            while(rs.next()){
                listSectors.add(rs.getString("name"));
              
            } 
            return listSectors;
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return listSectors;
    }
    
    public LinkedHashSet getRowsInGame(){
        LinkedHashSet<Integer> listRows = new LinkedHashSet<Integer>();

        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;
            

            String getRows = "SELECT tickets.ticket_on_game.row FROM tickets.ticket_on_game;";
            
            System.out.println(getRows);
            rs = stmt.executeQuery(getRows);

            while(rs.next()){
                listRows.add(Integer.parseInt(rs.getString("row")));
              
            } 
            return listRows;
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return listRows;
    }
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameterMap().size() == 6){
            updateSubscription(request, response);
        } else if(request.getParameterMap().size() == 1){
            deleteSubscription(request, response);   
        } else{
            addSubscription(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameterMap().size() == 6){
            updateSubscription(request, response);
        } else if(request.getParameter("del_sub") != null){
            deleteSubscription(request, response);   
        } else if(request.getParameter("perSub") != null){
            sub(request, response);
        } else if(request.getParameter("subscription") != null){
            addSubscription(request, response);
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
    
    
    
    
}

