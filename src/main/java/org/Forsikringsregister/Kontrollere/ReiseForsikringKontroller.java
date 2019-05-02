package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    @FXML
    void avbrytScene (ActionEvent event){
        Stage Reiseforsikring = (Stage) Avbryt.getScene().getWindow();
        Reiseforsikring.close();
    }

    @FXML
    void nyLagring (ActionEvent event) {
        LocalDate dato;
        if (Idag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = Dato.getValue();
        }/*
        Reiseforsikring reiseforsikring = new Reiseforsikring(ArligPremie.getText(), Belop.getText(), Sum.getText(),
                dato, Omrade.getText(), Betingelser.getText());
        Reiseforsikring.nyForsikring(reiseforsikring);
    */}
}
