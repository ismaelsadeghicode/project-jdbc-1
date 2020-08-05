package com.mapsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Esmaeil Sadeghi, 8/5/20 8:15 PM
 */
public class DBConnection {

    private Connection connection; // runtime

    public DBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("pls load db driver", e);
        }
    }

    public Connection openConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.50.150:1521:db11g", "CUSTOMER", "CUSTOMER");
        System.out.println("successfully");
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("close");
        }
    }

}
