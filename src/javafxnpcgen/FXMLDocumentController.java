/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnpcgen;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.NPC;
import model.RandomNameGen;
import model.FileReading;
import model.Monster;

/**
 *
 * @author tsemd
 */
public class FXMLDocumentController implements Initializable {
    Monster selectedNPC = new Monster();
    FileReading readFile = new FileReading();
    private final String CSV_MONSTER_FILE_PATH = "C:\\workspace\\JavaFXNPCGen\\monster_name.csv";
    private final String CSV_MAGIC_ITEM_FILE_PATH = "C:\\workspace\\JavaFXNPCGen\\magic_item_name.csv";
    private final String CSV_EQUIPMENT_FILE_PATH = "C:\\workspace\\JavaFXNPCGen\\equipment_name.csv";
    private final String CSV_SPELL_FILE_PATH = "C:\\workspace\\JavaFXNPCGen\\spell_name.csv";
    @FXML
    private Label label;
        
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
        getDataFromFields();
        try {
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
        
    
        readFile.readScanner(CSV_MONSTER_FILE_PATH);
        
//        Monster monsterType = new Monster();
//        monsterType.setClassName("");

        
        
    }
    public static int getRandomInt(Random random, int min, int max)
    {
      return random.nextInt(max - min + 1) + min;
    }
    public void setData(){
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
        ClassSelect.getItems().addAll(
                "Aberration"
                ,"Armor"
                ,"Construct"
                ,"Dragon"
                ,"Elemental"
                ,"Fey (Elf)"
                ,"Fiend"
                ,"Fiend "
                ,"Fiend (Demon)"
                ,"Fiend (Demon, Shapechanger)"
                ,"Fiend (Devil)"
                ,"Fiend (Shapechanger)"
                ,"Fiend (Yugoloth)"
                ,"Giant"
                ,"Humanoid"
                ,"Humanoid (Any Race)"
                ,"Humanoid (Derro)"
                ,"Humanoid (Dwarf)"
                ,"Humanoid (Elf)"
                ,"Humanoid (Gith)"
                ,"Humanoid (Meazel)"
                ,"Humanoid (Nagpa)"
                ,"Humanoid (Tortle)"
                ,"Humanoid (gnome)"
                ,"Language"
                ,"Monstrosity"
                ,"Ooze"
                ,"Plant"
                ,"Skill"
                ,"Titan"
                ,"Tool"
                ,"Undead"
                ,"Weapon"
                ,"aberration"
                ,"aberration (fey)"
                ,"aberration (shapechanger)"
                ,"aberration (shoth)"
                ,"beast"
                ,"beast, humanoid, giant, or monstrosity"
                ,"celestial"
                ,"celestial (dakini)"
                ,"celestial (shapechanger)"
                ,"celestial (titan)"
                ,"construct"
                ,"construct (devil)"
                ,"dragon"
                ,"dragon (shapechanger)"
                ,"elemental"
                ,"elemental (shapechanger)"
                ,"fey"
                ,"fey (shapechanger)"
                ,"fiend"
                ,"fiend (demon)"
                ,"fiend (demon, orc)"
                ,"fiend (demon, shapechanger)"
                ,"fiend (devil)"
                ,"fiend (gnoll)"
                ,"fiend (shapechanger)"
                ,"fiend (yugoloth)"
                ,"giant"
                ,"giant (cloud giant)"
                ,"giant (fire giant)"
                ,"giant (frost giant)"
                ,"giant (hill giant)"
                ,"giant (shapechanger, titan)"
                ,"giant (stone giant)"
                ,"giant (storm giant)"
                ,"humanoid"
                ,"humanoid "
                ,"humanoid (Simic hybrid)"
                ,"humanoid (aarakocra)"
                ,"humanoid (any race)"
                ,"humanoid (bearfolk)"
                ,"humanoid (bullywug)"
                ,"humanoid (burrowling)"
                ,"humanoid (dark folk)"
                ,"humanoid (derro)"
                ,"humanoid (dhampir)"
                ,"humanoid (dragonborn)"
                ,"humanoid (dwarf)"
                ,"humanoid (elf)"
                ,"humanoid (erina)"
                ,"humanoid (firenewt)"
                ,"humanoid (gearforged)"
                ,"humanoid (giant)"
                ,"humanoid (gith)"
                ,"humanoid (gnoll)"
                ,"humanoid (gnoll, shapechanger)"
                ,"humanoid (gnome)"
                ,"humanoid (goblinoid)"
                ,"humanoid (grimlock)"
                ,"humanoid (grung)"
                ,"humanoid (half-elf)"
                ,"humanoid (human)"
                ,"humanoid (human, shapechanger)"
                ,"humanoid (kenku)"
                ,"humanoid (kobold)"
                ,"humanoid (kraul)"
                ,"humanoid (kryt)"
                ,"humanoid (kuo-toa)"
                ,"humanoid (lemurfolk)"
                ,"humanoid (lizardfolk)"
                ,"humanoid (merfolk)"
                ,"humanoid (noctiny)"
                ,"humanoid (orc)"
                ,"humanoid (quaggoth)"
                ,"humanoid (ramag)"
                ,"humanoid (ratfolk)"
                ,"humanoid (roachling)"
                ,"humanoid (roackling)"
                ,"humanoid (sahuagin)"
                ,"humanoid (shadow fey)"
                ,"humanoid (shapechanger)"
                ,"humanoid (shapechanger, nkosi)"
                ,"humanoid (simian)"
                ,"humanoid (thri-kreen)"
                ,"humanoid (tiefling)"
                ,"humanoid (tosculi)"
                ,"humanoid (troglodyte)"
                ,"humanoid (trollkin)"
                ,"humanoid (xvart)"
                ,"humanoid (yakirian)"
                ,"humanoid (yuan-ti)"
                ,"monstrosity"
                ,"monstrosity (shapechanger)"
                ,"monstrosity (shapechanger, yuan-ti)"
                ,"monstrosity (titan)"
                ,"ooze"
                ,"plant"
                ,"plant (shapechanger)"
                ,"swarm"
                ,"swarm of Medium humanoids"
                ,"swarm of Tiny beasts"
                ,"swarm of Tiny constructs"
                ,"swarm of medium undead"
                ,"swarm of tiny aberrations"
                ,"swarm of tiny beasts"
                ,"swarm of tiny constructs"
                ,"swarm of tiny elementals"
                ,"swarm of tiny fey"
                ,"swarm of tiny monstrosities"
                ,"undead"
                ,"undead (shapechanger)"
                ,"undead (shapeshifter)"
        );
        

    }
    
}
