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
import service.ListItem;
/**
 *
 * @author tsemd
 * @version class defines methods for interacting with the AWS RDS database
 */
public class DatabaseController {
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

    //Method for inserting data into a table
    public void addRow(ListItem row, String table_name) {

            String sql_comm = "INSERT INTO " + table_name + " VALUES ('" + row.getItem_name() + "', " + row.getItem_description()+ "', " + row.getQuantity() + ", " + row.getPriority() + ", " + row.getValue() + ")";

            try {
                    stmt.executeUpdate(sql_comm);
            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }

    //Method for removing data from a table
    public void removeRow(String item, String table_name) {

            String sql_comm = "DELETE FROM " + table_name + " WHERE Item = '" + item + "'";

            try {
                    stmt.executeUpdate(sql_comm);
            } catch (SQLException e) {
                    e.printStackTrace();
            }

    }

    //Method for pulling data out of a table
    public ArrayList<ListItem> selectData(String table_name) {

            ArrayList<ListItem> list_from_db = new ArrayList<ListItem>();

            String sql_comm = "SELECT Item, Quant, Prior, Value FROM " + table_name;

            try {
                    ResultSet rs = stmt.executeQuery(sql_comm);

                    while(rs.next()) {

                          list_from_db.add(new ListItem(rs.getString("Item")
                                  , Double.toString(rs.getDouble("Value"))
                                  , Integer.toString(rs.getInt("Prior"))
                                  , rs.getString("Description")
                                  , Integer.toString(rs.getInt("Quant"))));
                    }

                    return list_from_db;

            } catch (SQLException e) {
                    e.printStackTrace();
            }

            return null;

    }

    //Method for retrieving all of the table names from the db
    public ArrayList<String> getTables(){

            ArrayList<String> tables = new ArrayList<String>();

            try {

                    DatabaseMetaData md = current_connection.getMetaData();
                    ResultSet rs = md.getTables(null, null, "%", null);

                    while(rs.next()) tables.add(rs.getString(3));

                    return tables;

            } catch (SQLException e) {
                    e.printStackTrace();
            }

            return null;

    }

    //Method not used at runtime currently, but will wipe all tables from the db
    public static void cleanse() {

            try {

                    DatabaseMetaData md = current_connection.getMetaData();
                    ResultSet rs = md.getTables(null, null, "%", null);

                    stmt = current_connection.createStatement();

                    while(rs.next()) stmt.executeUpdate("DROP TABLE " + rs.getString(3));

            } catch (SQLException e) {
                    e.printStackTrace();
            }

    }
	
}
