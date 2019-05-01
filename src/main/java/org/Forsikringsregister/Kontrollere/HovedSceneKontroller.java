package org.Forsikringsregister.Kontrollere;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


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
            Stage visRegister = openStage("../Kundeliste.fxml");
            visRegister.showAndWait();
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
