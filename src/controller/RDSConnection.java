/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author tsemd
 * @version establishes remote connection to the RDS database, the credentials are provided in the URL for the db
 */
public class RDSConnection {
    public static Connection getRemoteConnection() {

            Connection con = null;

            try {
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://shoppinglists.cpawwq2rtp0c.us-east-2.rds.amazonaws.com/ShoppingLists?user=bertie&password=password1");

                    return con;
            }
            catch (ClassNotFoundException e) { 
                    e.printStackTrace();
                    }
            catch (SQLException e) {
                    e.printStackTrace();
            }

        return null;
      }

}
	
	

