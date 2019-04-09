/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import service.NPC;

/**
 * FXML Controller class
 *
 * @author tsemd
 */
public class DetailsViewController implements Initializable {
    private NPC selectionNPC;
    @FXML private TableView<NPC> tableView;
    @FXML private TableColumn<NPC, String> strengthCol;
    @FXML private TableColumn<NPC, String> constitutionCol;
    @FXML private TableColumn<NPC, String> dexterityCol;
    @FXML private TableColumn<NPC, String> intelligenceCol;
    @FXML private TableColumn<NPC, String> wisdomCol;
    @FXML private TableColumn<NPC, String> charismaCol;
    @FXML private TextField ArmorClass;
    @FXML private TextField HitPoints;
    @FXML private TextField Speed;
    @FXML private TextField Attacks;
    @FXML private TextField Name;
    @FXML private TextField Level;
    public void initData(NPC npc) {        
        ArmorClass.setText(npc.getArmorClass());
        HitPoints.setText(npc.getHitPoints());
        Speed.setText(npc.getSpeed());
        Attacks.setText(npc.getAttacks());
        Name.setText(npc.getName());
        Level.setText(npc.getLevel());
        TableView tableView = new TableView();
        tableView.getItems().add(npc);
//        strengthCol.setText(npc.getStrength());
//        constitutionCol.setText(npc.getConstitution());
//        dexterityCol.setText(npc.getDexterity());
//        intelligenceCol.setText(npc.getIntelligence());
//        wisdomCol.setText(npc.getWisdom());
//        charismaCol.setText(npc.getCharisma());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        strengthCol.setCellValueFactory(new PropertyValueFactory<NPC, String>("STR"));
        constitutionCol.setCellValueFactory(new PropertyValueFactory<NPC, String>("CON"));
        dexterityCol.setCellValueFactory(new PropertyValueFactory<NPC, String>("DEX"));
        intelligenceCol.setCellValueFactory(new PropertyValueFactory<NPC, String>("INT"));
        wisdomCol.setCellValueFactory(new PropertyValueFactory<NPC, String>("WIS"));
        charismaCol.setCellValueFactory(new PropertyValueFactory<NPC, String>("CHAR"));
        
        
        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        
        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    } 
    public void changeStrengthCellEvent(CellEditEvent edittedCell)
    {
        NPC selectedNPC =  tableView.getSelectionModel().getSelectedItem();
        selectedNPC.setStrength(edittedCell.getNewValue().toString());
    }
    public void changeConstitutionCellEvent(CellEditEvent edittedCell)
    {
        NPC selectedNPC =  tableView.getSelectionModel().getSelectedItem();
        selectedNPC.setConstitution(edittedCell.getNewValue().toString());
    }
    public void changeDexterityCellEvent(CellEditEvent edittedCell)
    {
        NPC selectedNPC =  tableView.getSelectionModel().getSelectedItem();
        selectedNPC.setDexterity(edittedCell.getNewValue().toString());
    }
    public void changeWisdomCellEvent(CellEditEvent edittedCell)
    {
        NPC selectedNPC =  tableView.getSelectionModel().getSelectedItem();
        selectedNPC.setWisdom(edittedCell.getNewValue().toString());
    }
    public void changeIntelligenceCellEvent(CellEditEvent edittedCell)
    {
        NPC selectedNPC =  tableView.getSelectionModel().getSelectedItem();
        selectedNPC.setIntelligence(edittedCell.getNewValue().toString());
    }
    public void changeCharismaCellEvent(CellEditEvent edittedCell)
    {
        NPC selectedNPC =  tableView.getSelectionModel().getSelectedItem();
        selectedNPC.setCharisma(edittedCell.getNewValue().toString());
    }
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}
