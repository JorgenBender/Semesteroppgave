package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class HusforsikringKontroller {

    @FXML
    private TextField ArligPremie;

    @FXML
    private TextField Belop;

    @FXML
    private TextField Byggear;

    @FXML
    private TextField Materiale;

    @FXML
    private TextField Kvadratmeter;

    @FXML
    private TextField InnboBelop;

    @FXML
    private TextField Adresse;

    @FXML
    private TextField BoligType;

    @FXML
    private TextField Standard;

    @FXML
    private TextField BygningBelop;

    @FXML
    private DatePicker Dato;

    @FXML
    private TextArea Betingelser;

    @FXML
    private CheckBox Idag;

    @FXML
    private Button Lagre;

    @FXML
    private Button Avbryt;

    @FXML
    void IDagChecked (ActionEvent event){
        if(Idag.isSelected()) {
            Dato.setValue(LocalDate.now());
        }
    }

}
