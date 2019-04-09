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
        Name.setText(npc.getName());
        Level.setText(npc.getLevel());
        tableView.setItems(getAttributes(npc));
//        tableView.setItems(getAttributes());
    }
    /**
     * This method will return an ObservableList of NPC objects
     */
    public ObservableList<NPC>  getAttributes(NPC npc)
    {
        ObservableList<NPC> attributes = FXCollections.observableArrayList();
        attributes.add(new NPC(npc.getStrength(), 
                npc.getConstitution(),
                npc.getDexterity(),
                npc.getIntelligence(),
                npc.getWisdom(),
                npc.getCharisma()
            )
        );
        
        return attributes;
    }
//    public ObservableList<NPC>  getAttributes()
//    {
//        ObservableList<NPC> attributes = FXCollections.observableArrayList();
//        attributes.add(new NPC(selectionNPC.getStrength(), 
//                selectionNPC.getConstitution(),
//                selectionNPC.getDexterity(),
//                selectionNPC.getIntelligence(),
//                selectionNPC.getWisdom(),
//                selectionNPC.getCharisma()
//            )
//        );
//        
//        return attributes;
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        
        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        strengthCol.setCellFactory(TextFieldTableCell.forTableColumn());
        constitutionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dexterityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        intelligenceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        wisdomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        charismaCol.setCellFactory(TextFieldTableCell.forTableColumn());
       
        
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
