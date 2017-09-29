package com.sapient.sterlingCourier.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect{

                private static final String oraUser = "hr";
                //private static final String oraUser = "STERLINGCOURIERDATABASE";
                private static final String oraPwd = "hr";
               //private static final String oraCS = "jdbc:oracle:thin:@10.207.62.166:1521:xe";
              private static final String oraCS = "jdbc:oracle:thin:@localhost:1521:xe";
                public static Connection getConnection() throws SQLException {
                                try {
                                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                } catch (ClassNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                return DriverManager.getConnection(oraCS, oraUser, oraPwd);

                }

                public static void showErrorMessage(SQLException e) {
                                System.err.println("Error :" + e.getMessage());
                                System.err.println("Error Code :" + e.getErrorCode());
                }

}
