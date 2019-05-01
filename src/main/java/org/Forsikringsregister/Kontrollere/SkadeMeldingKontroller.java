package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Skademelding;

import java.time.LocalDate;

public class SkadeMeldingKontroller extends Kontroller{

    @FXML
    private TextField SkadeNummer;

    @FXML
    private TextField TakseringsBelop;

    @FXML
    private TextField Type;

    @FXML
    private TextField UtbetaltBelop;

    @FXML
    private TextArea Beskrivelse;

    @FXML
    private TextArea KontaktInfo;

    @FXML
    private DatePicker Dato;

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
        Stage Skademelding = (Stage) Avbryt.getScene().getWindow();
        Skademelding.close();
    }

    @FXML
    void nyLagring(ActionEvent event){
        LocalDate dato;
        if (Idag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = Dato.getValue();
        }/*
        Skademelding skademelding = new Skademelding(SkadeNummer.getText(), TakseringsBelop.getText(), Type.getText(),
                UtbetaltBelop.getText(), dato, Beskrivelse.getText(), KontaktInfo.getText());
        Skademelding.nySkademelding(skademelding);
    */}
}
