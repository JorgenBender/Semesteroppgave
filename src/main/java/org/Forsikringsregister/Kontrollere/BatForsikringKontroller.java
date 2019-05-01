package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class BatForsikringKontroller extends Kontroller{

    private Kunde kunde;
    public BatForsikringKontroller(Kunde kunde){
        this.kunde=kunde;
    }

    @FXML
    private TextField ArligPremie;

    @FXML
    private TextField Belop;

    @FXML
    private TextField RegNummer;

    @FXML
    private TextField LengdeFot;

    @FXML
    private TextField Eier;

    @FXML
    private TextField Battype;

    @FXML
    private TextField Arsmodell;

    @FXML
    private TextField MotorType;

    @FXML
    private TextField MotorStyrke;

    @FXML
    private TextField Modell;

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
    void idagChecked (ActionEvent event){
        if(Idag.isSelected()) {
            Dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt (ActionEvent event){
        Stage batforsikring = (Stage) Avbryt.getScene().getWindow();
        batforsikring.close();
    }

    public void initialize() {
    }
}
