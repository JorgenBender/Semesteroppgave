package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class HovedSceneKontroller extends Kontroller{

    @FXML
    private Button opprettKunde;

    @FXML
    private Button register;

    @FXML
    void opprettKunde(ActionEvent event) {

        try {
            Stage opprettKunde = openStage("../NyKunde.fxml");
            opprettKunde.showAndWait();
        }
        catch (IOException e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void visRegister(ActionEvent event) {

        try {
            Stage opprettKunde = openStage("../Kundeliste.fxml");
            opprettKunde.showAndWait();
        }
        catch (IOException e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
        }
    }
    public void initialize() {
        try {
           Stage importerKunde = openStage("../ImporterKundeRegister.fxml");
           importerKunde.showAndWait();
        }
        catch (IOException e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
        }
    }
}
