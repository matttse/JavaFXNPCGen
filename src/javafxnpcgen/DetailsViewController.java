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
import javafx.scene.control.TextField;
import model.NPC;
import model.ItemDetails;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import service.Randomizer;
import service.FileReading;

/**
 * FXML Controller class
 *
 * @author tsemd
 */
public class DetailsViewController implements Initializable {
    
    //local reference via windows PC to web crawled items
    private final String CSV_MAGIC_ITEM_FILE_PATH = ".\\magic_item_name.csv";
    private final String CSV_EQUIPMENT_FILE_PATH = ".\\equipment_name.csv";
    private final String CSV_SPELL_FILE_PATH = ".\\spell_name.csv";
    //ability score fields
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
    //item table fields
    @FXML private TableView<ItemDetails> tableView;
    @FXML private TableColumn<ItemDetails, String> itemNameCol;
    @FXML private TableColumn<ItemDetails, String> itemDescriptionCol;
    @FXML private TableColumn<ItemDetails, String> valueCol;
    @FXML private TableColumn<ItemDetails, String> experienceCol;
    private List<String[]> itemList;
    protected ObservableList<ItemDetails> items = FXCollections.observableArrayList();
    
    Randomizer letsRoll = new Randomizer();
    
    // manually add isntance varaibles to create new itemdetail object
    @FXML private ComboBox<String> itemNameComboBox;
    @FXML private TextField itemDescriptionTextField;
    @FXML private TextField experienceTextField;
    @FXML private TextField valueTextField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {            
            
        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
            
    } 
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    //callable init from main menu
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
        
        itemNameCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("name"));
        itemDescriptionCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("description"));
        valueCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("value"));
        experienceCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("experience"));
        //set items from randomization and read
        tableView.setItems(getItems());
        //allow tables to be editable
        tableView.setEditable(true);
        //only allows edits for val and xp
        valueCol.setCellFactory(TextFieldTableCell.forTableColumn());
        experienceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    /*
    * method to collect and store items
    */    
    public ObservableList<ItemDetails> getItems() {
        
        FileReading readLocalFiles = new FileReading();
        Random rand = new Random();
        try {
            itemList = readLocalFiles.readScanner(CSV_EQUIPMENT_FILE_PATH);
            itemList.addAll(readLocalFiles.readScanner(CSV_MAGIC_ITEM_FILE_PATH));
            itemList.addAll(readLocalFiles.readScanner(CSV_SPELL_FILE_PATH));
            
        } catch (IOException ex) {
            Logger.getLogger(DetailsViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }//end try
        
        
        for (int i = 0; i < 1; i++) {
            String[] get = itemList.get(i);
            //store all items for later addition
            for (int start = 0; start < get.length; start++) {
                String name = get[start];
                itemNameComboBox.getItems().add(name);
            }//end for to loop through all items
            //roll for random number and random number of items
            Collections.shuffle(Arrays.asList(get));
            int randomNumberOfItems = letsRoll.getRandomInt(rand, 1, (int) Math.round(Double.valueOf(20)));
            for (int j = 0; j < randomNumberOfItems; j++) {
                String name = get[j];
                
                items.add(new ItemDetails(
                        name,
                        "",
                        String.valueOf(Math.round(
                                (letsRoll.getRandomInt(rand, 1, 100)+99)*100
                        )),
                        String.valueOf(Math.round(
                                (letsRoll.getRandomInt(rand, 1, 100)+99)*100
                        ))
                    )
                ); //end item list addition                   

            }//end item generation default

        }//end for to get into csv
            
        return items;
    }   
    /**
     * This method adds items to table
     * */
    public void newItemButtonPushed(){
        ItemDetails newItem = new ItemDetails(
                itemNameComboBox.getValue(),
                itemDescriptionTextField.getText(),
                experienceTextField.getText(),
                valueTextField.getText()
        );
        tableView.getItems().add(newItem);
        
    }
    
    /**
     * This method adds items to table
     * */
    public void deleteItemButtonPushed(){
        ObservableList<ItemDetails> selectedRows, allItems;
        allItems = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (ItemDetails item : selectedRows)
        {
            allItems.remove(item);
        }
        
    }
}

