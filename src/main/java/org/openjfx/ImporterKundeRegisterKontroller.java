package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

        Stage stage = (Stage) ja.getScene().getWindow();
        stage.close();

    }


    public void initialize() {


    }
}

