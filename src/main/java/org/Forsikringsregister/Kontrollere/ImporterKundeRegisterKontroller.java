package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.IO.lesJobj;
import org.Forsikringsregister.IO.skrivCsv;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.IOException;
import java.util.ArrayList;

public class ImporterKundeRegisterKontroller{

    @FXML
    private Button ja;

    @FXML
    private  Button nei;

    @FXML
    void ja (ActionEvent event) {

        lesJobj leser = new lesJobj();

        try{Kunderegister.setKundeliste(leser.lesKundeliste());}
        catch (IOException e){

        }
        catch (InvalidKundeFormatException e){

        }
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

