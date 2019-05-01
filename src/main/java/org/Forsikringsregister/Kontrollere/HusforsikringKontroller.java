package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Husforsikring;

import java.time.LocalDate;

public class HusforsikringKontroller extends Kontroller{

    @FXML
    private TextField arligPremie;

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

    @FXML
    void avbrytScene (ActionEvent event){
        Stage HusForsikring = (Stage) Avbryt.getScene().getWindow();
        HusForsikring.close();
    }

    @FXML
    void nyLagring (ActionEvent event) {
        LocalDate dato;
        if (Idag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = Dato.getValue();
        }/*
        Husforsikring husforsikring = new Husforsikring(arligPremie.getText(), dato, Belop.getText(), Byggear.getText(),
                Materiale.getText(), Kvadratmeter.getText(), InnboBelop.getText(), Adresse.getText(), BoligType.getText(),
                Standard.getText(), BygningBelop.getText(), Betingelser.getText());
        Husforsikring.nyHusforsikring(husforsikring);
    */}


}
