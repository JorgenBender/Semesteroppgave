package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class ReiseForsikringKontroller extends Kontroller {

    private Kunde kunde;
    public ReiseForsikringKontroller(Kunde kunde){
        this.kunde=kunde;
    }

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
    public void initialize() {
    }
}
