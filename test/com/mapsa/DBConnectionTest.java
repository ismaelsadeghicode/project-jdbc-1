package com.mapsa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author Esmaeil Sadeghi, 8/5/20 8:27 PM
 */
public class DBConnectionTest {

    private static DBConnection dbConnection;

    @BeforeClass
    public static void beforeClass() {
        dbConnection = new DBConnection();
    }

    @Test
    public void openConnection() throws SQLException {
        dbConnection.openConnection();
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        dbConnection.closeConnection();
    }
}