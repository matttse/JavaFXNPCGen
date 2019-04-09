/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import service.NPC;

/**
 * FXML Controller class
 *
 * @author tsemd
 */
public class DetailsViewController implements Initializable {
    private NPC selectionNPC;
    
    @FXML private TextField strengthTextField;
    @FXML private TextField constitutionTextField;
    @FXML private TextField dexterityTextField;
    @FXML private TextField intelligenceTextField;
    @FXML private TextField wisdomTextField;
    @FXML private TextField charismaTextField;
    @FXML private TextField ArmorClass;
    @FXML private TextField HitPoints;
    @FXML private TextField Speed;
    @FXML private TextField Attacks;
    @FXML private TextField Name;
    @FXML private TextField Level;
    public void initData(NPC npc) {        
        ArmorClass.setText(npc.getArmorClass());
        HitPoints.setText(npc.getHitPoints());
        Name.setText(npc.getName());
        Level.setText(npc.getLevel());
        strengthTextField.setText(npc.getStrength());
        constitutionTextField.setText(npc.getConstitution());
        dexterityTextField.setText(npc.getDexterity());
        intelligenceTextField.setText(npc.getIntelligence());
        wisdomTextField.setText(npc.getWisdom());
        charismaTextField.setText(npc.getCharisma());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
              
        
    } 
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}
