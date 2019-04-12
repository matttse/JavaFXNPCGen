/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.NPC;
import model.ItemDetails;
import dao.DatabaseController;
import javafx.scene.control.TextArea;
import model.Equipment;

/**
 * FXML Controller class
 *
 * @author tsemd
 */
public class DetailsViewController implements Initializable {
    
    int pri;
    int quant;
    double price;
    String item;
    String listNameData;
    private NPC selectionNPC;    
    private Equipment equipmentList;
    @FXML private TextField strengthTextField;
    @FXML private TextField constitutionTextField;
    @FXML private TextField dexterityTextField;
    @FXML private TextField intelligenceTextField;
    @FXML private TextField wisdomTextField;
    @FXML private TextField charismaTextField;
    @FXML private TextField ArmorClass;
    @FXML private TextField HitPoints;
    @FXML private TextField Name;
    @FXML private TextField Level;
    @FXML private TextArea Notes;
    
    ArrayList<ItemDetails> itemList = new ArrayList<ItemDetails>();

    DatabaseController db; //create new DatabaseController object

    public DetailsViewController() {
        db = new DatabaseController(); //initialize new DatabaseController object

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {            
            //open the database connection
            db.openConnection();
        
    } 
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

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
        Notes.setText(npc.getNotes());
        
    }
    
    public void setEquipmentList(Equipment itemList) {
        equipmentList.setItemList(itemList.getItemList());
    }
    
    
    
    
}
