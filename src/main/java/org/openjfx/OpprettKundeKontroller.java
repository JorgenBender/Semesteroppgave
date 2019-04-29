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
        kunde.addForsikring(new Batforsikring(1,1,dato,"gw","ewgsgw","egwrh",
                                            "gefwedfgn","ergfwqeg",1,"rgefw","fgbsd","grgge"));
        Kunderegister.nyKunde(kunde);
        KunderegisterIO.exporterKundeliste(Kunderegister.getKundeliste());
        System.out.println(Kunderegister.getKundeliste().toString());
    }

    @FXML
    void iDagChecked (ActionEvent event){ nyKundeRegDato.setValue(LocalDate.now()); }

    public void initialize() {

        System.out.println(Kunderegister.getKundeliste().size());

    }
}

