package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ImporterKundeRegisterKontroller {

    @FXML
    private Button ja;

    @FXML
    private  Button nei;

    @FXML
    void ja (ActionEvent event) {

        MainSceneController.setKunderegister(KunderegisterIO.lastOppKundeRegister());

    }

    @FXML
    void nei (ActionEvent event) {

        Kunderegister kunderegister = new Kunderegister();

    }


    public void initialize() {

    }
}

