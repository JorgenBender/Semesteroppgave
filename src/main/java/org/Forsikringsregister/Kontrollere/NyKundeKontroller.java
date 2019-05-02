package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.time.LocalDate;

public class NyKundeKontroller extends Kontroller{

    @FXML private DatePicker nyKundeRegDato;    @FXML private CheckBox iDag;

    @FXML private TextField nyKundeNavn;        @FXML private TextField nyKundeFakturaAdresse;

    @FXML private Button avbryt;                @FXML private Button nyKundeRegistrer;

    @FXML private TextField nyKundeForsikringsnummer;

    @FXML
    void nyRegistrering (ActionEvent event){

        LocalDate dato;
        if(iDag.isSelected()){
            dato = LocalDate.now();
        }
        else{
            dato = nyKundeRegDato.getValue();
        }
        Kunderegister.nyKunde(new Kunde(nyKundeNavn.getText(), dato, nyKundeFakturaAdresse.getText(),nyKundeForsikringsnummer.getText()));
        Stage stage = (Stage)nyKundeRegistrer.getScene().getWindow();
        stage.close();
    }

    @FXML
    void avbryt (ActionEvent event){
        Stage stage = (Stage) avbryt.getScene().getWindow();
        stage.close();
    }


    @FXML
    void iDagChecked (ActionEvent event){
        if(iDag.isSelected()) {
            nyKundeRegDato.setValue(LocalDate.now());
        }
    }

    public void initialize() {

    }
}

