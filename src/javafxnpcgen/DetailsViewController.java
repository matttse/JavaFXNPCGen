/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import service.NPC;

/**
 * FXML Controller class
 *
 * @author tsemd
 */
public class DetailsViewController implements Initializable {
    private NPC selectionNPC;
    @FXML private TextField ArmorClass;
    @FXML private TextField HitPoints;
    @FXML private TextField Speed;
    @FXML private TextField Attacks;
    @FXML private TextField Name;
    @FXML private TextField Level;
    public void initData(NPC npc) {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
