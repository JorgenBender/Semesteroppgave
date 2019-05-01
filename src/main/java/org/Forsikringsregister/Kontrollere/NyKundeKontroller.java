package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.IO.*;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.IOException;
import java.time.LocalDate;

public class NyKundeKontroller extends Kontroller{

    @FXML
    private DatePicker nyKundeRegDato;

    @FXML
    private CheckBox iDag;

    @FXML
    private TextField nyKundeNavn;

    @FXML
    private TextField nyKundeFakturaAdresse;

    @FXML
    private TextField nyKundeForsikringsnummer;

    @FXML
    private Button nyKundeRegistrer;

    @FXML
    private Button avbryt;

    @FXML
    void nyRegistrering (ActionEvent event){

        LocalDate dato;
        if(iDag.isSelected()){
            dato = LocalDate.now();
        }
        else{
            dato = nyKundeRegDato.getValue();
        }
        Kunde kunde = new Kunde(nyKundeNavn.getText(), dato, nyKundeFakturaAdresse.getText(),nyKundeForsikringsnummer.getText());
        Kunderegister.nyKunde(kunde);
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

        //System.out.println(Kunderegister.getKundeliste().size());

    }
}

