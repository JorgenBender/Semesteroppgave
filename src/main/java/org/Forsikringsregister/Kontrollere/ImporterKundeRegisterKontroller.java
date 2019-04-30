package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;
import org.Forsikringsregister.KunderegisterIO;

import java.util.ArrayList;

public class ImporterKundeRegisterKontroller{

    @FXML
    private Button ja;

    @FXML
    private  Button nei;

    @FXML
    void ja (ActionEvent event) {

        Kunderegister.setKundeliste(KunderegisterIO.importerKundeliste());
        Stage stage = (Stage) ja.getScene().getWindow();
        stage.close();
    }

    @FXML
    void nei (ActionEvent event) {

        Kunderegister.setKundeliste(new ArrayList<Kunde>());
        Stage stage = (Stage) nei.getScene().getWindow();
        stage.close();

    }


    public void initialize() {


    }
}

