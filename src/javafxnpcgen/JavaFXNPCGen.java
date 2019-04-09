/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author tsemd
 */
public class JavaFXNPCGen extends Application {

    
    @Override
    public void start(Stage primaryStage) throws Exception {        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setTitle("NPCGen");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
