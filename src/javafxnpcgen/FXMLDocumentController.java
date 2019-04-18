/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.Equipment;
import model.NPC;
import model.RandomNameGen;
import model.FileReading;
import model.ItemDetails;
import model.Monster;

/**
 *
 * @author tsemd
 */
public class FXMLDocumentController implements Initializable {
    Monster selectedNPC = new Monster();
    private Equipment equipmentList;
    private final String CSV_MONSTER_FILE_PATH = "C:\\workspace\\JavaFXNPCGen\\monster_name.csv";
    
    private Map selectedItems;
        
    @FXML
    private ComboBox<Integer> NumberOfNPCsSelect;
    @FXML
    private ComboBox<Integer> LevelSelect;
    @FXML
    private ComboBox<String> ClassSelect;
    @FXML
    private ComboBox<String> AbilityScore;
    @FXML
    private ComboBox<Integer> Modifier;
    @FXML
    private void resetButtonAction(ActionEvent event) {
        NumberOfNPCsSelect.setValue(1);
        LevelSelect.setValue(1);
        ClassSelect.setValue("Human");
        AbilityScore.setValue("1");//1, 2–3, 4–5, 6–7, 8–9, 10–11, 12–13, 14–15, 16–17, 18–19, 20–21, 22–23, 24–25, 26–27, 28–29, 30
        Modifier.setValue(0);//+0, +1, +2, +3, +4, +5, +6, +7, +8, +9, +10
    }
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void GenerateNPCButton(ActionEvent event) {
//        getDataFromFields();
        try {
            for (int i = 0; i < NumberOfNPCsSelect.getValue(); i++) {
                getDataFromFields();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("DetailsView.fxml"));

                Parent detailScene = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Character Details");
                stage.setScene(new Scene(detailScene));
                stage.show();

                // access the controller and call a method
                DetailsViewController controller = loader.getController();

                controller.initData(selectedNPC);  
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setData();
    }
    
    public void getDataFromFields() {
        
        selectedNPC.setLevel(String.valueOf(LevelSelect.getSelectionModel().getSelectedIndex()+2));
        
        Random rand = new Random();
        if (AbilityScore.getSelectionModel().getSelectedIndex() == -1) {
            selectedNPC.setCharisma(String.valueOf(getRandomInt(rand, 1, 18)));
            selectedNPC.setConstitution(String.valueOf(getRandomInt(rand, 1, 18)));
            selectedNPC.setDexterity(String.valueOf(getRandomInt(rand, 1, 18)));
            selectedNPC.setIntelligence(String.valueOf(getRandomInt(rand, 1, 18)));
            selectedNPC.setStrength(String.valueOf(getRandomInt(rand, 1, 18)));
            selectedNPC.setWisdom(String.valueOf(getRandomInt(rand, 1, 18)));
        } else {
            int high = 18;
            int low = Modifier.getSelectionModel().getSelectedItem()+1;
            selectedNPC.setCharisma(String.valueOf(getRandomInt(rand, low, high)));
            selectedNPC.setConstitution(String.valueOf(getRandomInt(rand, low, high)));
            selectedNPC.setDexterity(String.valueOf(getRandomInt(rand, low, high)));
            selectedNPC.setIntelligence(String.valueOf(getRandomInt(rand, low, high)));
            selectedNPC.setStrength(String.valueOf(getRandomInt(rand, low, high)));
            selectedNPC.setWisdom(String.valueOf(getRandomInt(rand, low, high)));
        }
        
        switch (selectedNPC.getConstitution()) {
            case "16":
                {
                    int bonus = 1;
                    selectedNPC.setHitPoints(
                            String.valueOf(
                                    (LevelSelect.getSelectionModel().getSelectedItem() * getRandomInt(rand, 2, 10) + bonus)
                            )
                    );      break;
                }
            case "17":
                {
                    int bonus = 2;
                    selectedNPC.setHitPoints(
                            String.valueOf(
                                    (LevelSelect.getSelectionModel().getSelectedItem() * getRandomInt(rand, 2, 10) + bonus)
                            )
                    );      break;
                }
            default:
                selectedNPC.setHitPoints(
                        String.valueOf(
                                (LevelSelect.getSelectionModel().getSelectedItem() * getRandomInt(rand, 2, 10))
                        )
                );  break;
        }
        selectedNPC.setArmorClass("+".concat(
                Integer.toString(
                        getRandomInt(rand, 2, 10) + Modifier.getSelectionModel().getSelectedItem()
                )
            )
        );
        RandomNameGen name = new RandomNameGen();
        selectedNPC.setName(name.generateName());
        selectedNPC.setNotes(ClassSelect.getValue());
    }
    public static int getRandomInt(Random random, int min, int max)
    {
      return random.nextInt(max - min + 1) + min;
    }
    public void setData(){
        FileReading readLocalFiles = new FileReading();
        try {
            List<String[]> monsterList = readLocalFiles.readScanner(CSV_MONSTER_FILE_PATH);
            for (int i = 0; i < 1; i++) {
                String[] get = monsterList.get(i);
                for (int j = 0; j < get.length; j++) {
                    String monster_name = get[j];
                    ClassSelect.getItems().add(monster_name);
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NumberOfNPCsSelect.getItems().addAll(
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
        );
        // add items
        AbilityScore.getItems().addAll(
                "1","2-3","4-5","6-7","8-9","10-11","12-13","14-15","16-17","18-19"
                ,"20-21","22-23","24-25","26-27","28-29","30"
        );
        Modifier.getItems().addAll(
                0,1,2,3,4,5,6,7,8,9,10
        );
        LevelSelect.getItems().addAll(
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
        );
        

    }
    
}
