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
import dao.DatabaseController;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafxnpcgen.FXMLDocumentController.getRandomInt;
import model.FileReading;

/**
 * FXML Controller class
 *
 * @author tsemd
 */
public class DetailsViewController implements Initializable {
    

    private final String CSV_MAGIC_ITEM_FILE_PATH = ".\\magic_item_name.csv";
    private final String CSV_EQUIPMENT_FILE_PATH = ".\\equipment_name.csv";
    private final String CSV_SPELL_FILE_PATH = ".\\spell_name.csv";
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
    @FXML private TableView<ItemDetails> tableView;
    @FXML private TableColumn<ItemDetails, String> itemNameCol;
    @FXML private TableColumn<ItemDetails, String> itemDescriptionCol;
    @FXML private TableColumn<ItemDetails, String> valueCol;
    @FXML private TableColumn<ItemDetails, String> experienceCol;
    private List<String[]> itemList;
    protected ObservableList<ItemDetails> items = FXCollections.observableArrayList();

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
        
        itemNameCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("name"));
        itemDescriptionCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("description"));
        valueCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("value"));
        experienceCol.setCellValueFactory(new PropertyValueFactory<ItemDetails, String>("experience"));
            
        tableView.setItems(getItems());
        tableView.setEditable(true);
        valueCol.setCellFactory(TextFieldTableCell.forTableColumn());
        experienceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    
    public ObservableList<ItemDetails> getItems() {
        
        FileReading readLocalFiles = new FileReading();
        Random rand = new Random();
        try {
            itemList = readLocalFiles.readScanner(CSV_EQUIPMENT_FILE_PATH);
            itemList.addAll(readLocalFiles.readScanner(CSV_MAGIC_ITEM_FILE_PATH));
            itemList.addAll(readLocalFiles.readScanner(CSV_SPELL_FILE_PATH));
            System.out.print(itemList.size());
        } catch (IOException ex) {
            Logger.getLogger(DetailsViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 1; i++) {
            String[] get = itemList.get(i);
            Collections.shuffle(Arrays.asList(get));
            int randomNumberOfItems = getRandomInt(rand, 1, (int) Math.round(Double.valueOf(20)));
            for (int j = 0; j < randomNumberOfItems; j++) {
                String name = get[j];
                items.add(new ItemDetails(
                        name,
                        "",
                        String.valueOf(Math.round(
                                (getRandomInt(rand, 1, 100)+99)*100
                        )),
                        String.valueOf(Math.round(
                                (getRandomInt(rand, 1, 100)+99)*100
                        ))
                    )
                );                    

            }

        }
            
        return items;
    }   
    
}

