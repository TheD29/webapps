/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.db;

/**
 *
 * @author us9522
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {

    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;

    public static Connection getConnection() {
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/sample");
            conn = ds.getConnection();
        } catch (SQLException ex) {
            System.out.println("error number 1");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            System.out.println("error number 2");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}
