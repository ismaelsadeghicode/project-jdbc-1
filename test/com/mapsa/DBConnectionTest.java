package com.mapsa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

//    @Test
//    public void testQuery() throws SQLException {
//        Statement statement = dbConnection.getConnection().createStatement();
//        ResultSet resultSet = statement.executeQuery("select  * from CUSTOMER");
//        while (resultSet.next()) {
//            System.out.println(resultSet.getObject("ID"));
//            System.out.println(resultSet.getObject("FIRST_NAME"));
//            System.out.println(resultSet.getObject("LASTNAME"));
//            System.out.println("------------------------------------------");
//        }
//    }

    @Test
    public void findToObject() throws SQLException {
        Statement statement = dbConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select  * from CUSTOMER");

        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt(1));
            customer.setFirstName(resultSet.getString(2));
            customer.setLastName(resultSet.getString(3));
            customerList.add(customer);
        }

        for (Customer customer:customerList) {
            System.out.println(customer);
        }
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        dbConnection.closeConnection();
    }
}