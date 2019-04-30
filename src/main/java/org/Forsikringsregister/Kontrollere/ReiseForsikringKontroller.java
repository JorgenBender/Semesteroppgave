package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ReiseForsikringKontroller extends Kontroller {

    @FXML
    private TextField ArligPremie;

    @FXML
    private TextField Belop;

    @FXML
    private TextField Sum;

    @FXML
    private DatePicker Dato;

    @FXML
    private CheckBox Idag;

    @FXML
    private TextArea Omrade;

    @FXML
    private TextArea Betingelser;

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
