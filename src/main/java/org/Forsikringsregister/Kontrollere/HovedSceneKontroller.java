package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        tableView.getItems().setAll(Kunderegister.getKundeliste());
    }
}
