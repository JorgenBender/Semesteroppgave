package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.IO.lesCsv;
import org.Forsikringsregister.IO.lesJobj;
import org.Forsikringsregister.Programlogikk.Kunderegister;
import java.io.IOException;

public class ImporterKundeRegisterKontroller extends Kontroller{

    @FXML
    private ChoiceBox<String> ja;

    @FXML
    private  Button nei;

    @FXML
    void ja() {
        Stage stage = (Stage) ja.getScene().getWindow();

        switch (ja.getValue()){
            case ".csv":
                lesCsv leserCsv = new lesCsv();
                try{Kunderegister.setKundeliste(leserCsv.lesKundeliste());}
                catch (IOException e){
                }
                catch (InvalidKundeFormatException e){
                }
                stage.close();
                break;
            case ".jobj":
                lesJobj leserJobj = new lesJobj();
                try{Kunderegister.setKundeliste(leserJobj.lesKundeliste());}
                catch (IOException e){
                }
                catch (InvalidKundeFormatException e){
                }
                stage.close();
                break;
        }

    }

    @FXML
    void nei (ActionEvent event) {

        Kunderegister.setKundeliste(null);
        Stage stage = (Stage) nei.getScene().getWindow();
        stage.close();

    }


    public void initialize() {
        ja.getItems().addAll(
                ".csv",
                    ".jobj");
        ja.setOnAction(Event -> ja());

    }
}

