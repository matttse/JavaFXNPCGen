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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import service.LocalItemList;

/**
 *
 * @author tsemd
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button GenerateNPCButton;
    
    @FXML
    private Button ResetButton;
    
    @FXML
    private ComboBox<Integer> NumberOfNPCsSelect;
    @FXML
    private ChoiceBox<Integer> LevelSelect;
    @FXML
    private ChoiceBox<String> ClassSelect;
    @FXML
    private ChoiceBox<Integer> AbilityScoreLowSelect;
    @FXML
    private ChoiceBox<Integer> AbilityScoreHighSelect;
    
    @FXML
    private void resetButtonAction(ActionEvent event) {
        NumberOfNPCsSelect.setValue(1);
        LevelSelect.setValue(1);
        ClassSelect.setValue("");
        AbilityScoreLowSelect.setValue(1);//1, 2–3, 4–5, 6–7, 8–9, 10–11, 12–13, 14–15, 16–17, 18–19, 20–21, 22–23, 24–25, 26–27, 28–29, 30
        AbilityScoreHighSelect.setValue(-5);//−5, −4, −3, −2, −1, +0, +1, +2, +3, +4, +5, +6, +7, +8, +9, +10
    }
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
