package org.Forsikringsregister.Kontrollere;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.Forsikringsregister.Exceptions.InvalidFormatException;
import org.Forsikringsregister.IO.LesCsv;
import org.Forsikringsregister.IO.LesJobj;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;
import java.io.IOException;
import java.util.ArrayList;

public class ImporterKundeRegisterKontroller extends Kontroller{
/*
    @FXML
    private ComboBox<String> ja;

    @FXML
    private  Button nei;

    @FXML
    void ja() {
        Stage stage = (Stage) ja.getScene().getWindow();

        switch (ja.getValue()){
            case ".csv":
                LesCsv leserCsv = new LesCsv();
                try{Kunderegister.setKundeliste(leserCsv.lesKundeliste());}
                catch (IOException e){
                }
                catch (InvalidFormatException e){
                }
                catch (NullPointerException e){
                    //Du valgte ingen fil vendligst prøv igjen
                }
                if(Kunderegister.getKundeliste() != null){
                stage.close();}
                break;
            case ".jobj":
                LesJobj leserJobj = new LesJobj();
                try{Kunderegister.setKundeliste(leserJobj.lesKundeliste());}
                catch (IOException e){
                }
                catch (InvalidFormatException e){
                }
                catch (NullPointerException e){
                    //Du valgte ingen fil vendligst prøv igjen
                }
                if(Kunderegister.getKundeliste() != null){
                    stage.close();}
                break;
        }
    }

    @FXML
    void nei (ActionEvent event) {

        Kunderegister.setKundeliste(FXCollections.observableArrayList(new ArrayList<Kunde>()));
        Stage stage = (Stage) nei.getScene().getWindow();
        stage.close();

    }
    public void initialize() {
        ja.getItems().addAll(
                ".csv",
                    ".jobj");
        ja.setOnAction(Event -> ja());

    }*/
}

