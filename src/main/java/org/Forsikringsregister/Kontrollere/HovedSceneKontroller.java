package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;
import java.io.IOException;
import java.time.LocalDate;

public class HovedSceneKontroller extends Kontroller {

    @FXML
    private Button opprettKunde;
    @FXML
    private Button importerKundeliste;
    @FXML
    private TableView<Kunde> tableView;
    @FXML
    private TableColumn<Kunde, String> navn;
    @FXML
    private TableColumn<Kunde, LocalDate> datoKundeforhold;
    @FXML
    private TableColumn<Kunde, String> fakturaadresse;
    @FXML
    private TableColumn<Kunde, String> forsikringsnummer;
    @FXML
    private TableColumn<Kunde, String> antallForsikringer;

    @FXML
    public void selectKunde(MouseEvent event) {
        if (event.getClickCount() == 2) //Checking double click
        {
            try {
                Stage visKunde = openStageSendKunde("../KundeScene.fxml",tableView.getSelectionModel().getSelectedItem());
                visKunde.showAndWait();
            } catch (IOException e) {
                System.err.println("Cant load new window");
                System.err.println(e.getMessage());
            } catch (NullPointerException e){
                //Kan trykke på en tom tableview
            }

        }
    }
    @FXML
    void opprettKunde(ActionEvent event) {

        try {
            Stage nyKunde = openStage("../NyKunde.fxml");
            nyKunde.showAndWait();
        }
        catch (IOException e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
            tableView.getItems().setAll(Kunderegister.getKundeliste());
        }
    }
    @FXML
    void importerKundeliste (ActionEvent event) {
        try {
            Stage importerKunde = openStage("../ImporterKundeRegister.fxml");
            importerKunde.showAndWait();
        } catch (IOException e) {
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
        }
        tableView.getItems().setAll(Kunderegister.getKundeliste());
    }

    public void initialize() {
        navn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        datoKundeforhold.setCellValueFactory(new PropertyValueFactory<>("datoKundeforhold"));
        fakturaadresse.setCellValueFactory(new PropertyValueFactory<>("fakturaadresse"));
        forsikringsnummer.setCellValueFactory(new PropertyValueFactory<>("forsikringsnummer"));
        antallForsikringer.setCellValueFactory(new PropertyValueFactory<>("antallForsikringer"));
    }
}
