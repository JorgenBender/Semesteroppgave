package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class SkadeMeldingKontroller {

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
}
