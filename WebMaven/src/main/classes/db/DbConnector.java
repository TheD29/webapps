package db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Dima on 30.03.2017.
 */
public class DbConnector {

    private static InitialContext ic;
    private static Connection conn;

    public static synchronized Connection getConnection() {
        try {
            ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/magazine");
            conn = ds.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return conn;

    }

    private DbConnector() {

    }


}
