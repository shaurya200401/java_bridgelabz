package com.bridgelabz.payroll;

import java.sql.*;
import java.util.Enumeration;

public class payroll_service {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "password";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Loaded Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace();
            return;
        }

        // List Registered Drivers
        listDrivers();

        // Try Connection
        try (Connection connection =
                     DriverManager.getConnection(jdbcURL, username, password)) {

            if (connection != null) {
                System.out.println("Connection Established Successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        System.out.println("Registered JDBC Drivers:");

        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println("-> " + driver.getClass().getName());
        }
    }
}