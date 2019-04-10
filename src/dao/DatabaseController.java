/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ItemDetails;
/**
 *
 * @author tsemd
 * @version class defines methods for interacting with the AWS RDS database
 */
public class DatabaseController  {
    private static Connection current_connection = RDSConnection.getRemoteConnection();
    private static Statement stmt;

    public void openConnection() {

            //current_connection = RDSConnection.getRemoteConnection();

            try {
                    stmt = current_connection.createStatement();
            }
            catch(SQLException e) {
                    e.printStackTrace();
            }
    }

    //Method to create a table with a given table_name
    public void createTable(String table_name) {

            String sql_comm = "CREATE TABLE IF NOT EXISTS " + table_name +
                                              " (Item VARCHAR(255), " +
                                              " (Description VARCHAR(255), " +
                                              " Quant INTEGER, " +
                                              " Prior INTEGER, " +
                                              " Value DOUBLE)";

            try {
                    stmt.executeUpdate(sql_comm);
            } catch (SQLException e) {
                    e.printStackTrace();
            }

    }
}
