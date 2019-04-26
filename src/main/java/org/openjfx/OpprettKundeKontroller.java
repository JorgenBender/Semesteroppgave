package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class OpprettKundeKontroller{

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
    void nyRegistrering (ActionEvent event){

        LocalDate dato;
        if(iDag.isSelected()){
            dato = LocalDate.now();
        }
        else{
            dato = nyKundeRegDato.getValue();
        }
        Kunde kunde = new Kunde(dato, nyKundeNavn.getText(), nyKundeFakturaAdresse.getText(),nyKundeForsikringsnummer.getText());
        Kunderegister.nyKunde(kunde);
        KunderegisterIO.exporterKundeliste(Kunderegister.getKundeliste());
        System.out.println(kunde);
    }

    @FXML
    void iDagChecked (ActionEvent event){ nyKundeRegDato.setValue(LocalDate.now()); }

    public void initialize() {

        System.out.println(Kunderegister.getKundeliste().size());

    }
}

