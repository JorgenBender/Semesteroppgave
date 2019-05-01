package org.Forsikringsregister.Kontrollere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.time.LocalDate;

public class KundelisteKontroller extends Kontroller {

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

    public void initialize() {

        navn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        datoKundeforhold.setCellValueFactory(new PropertyValueFactory<>("datoKundeforhold"));
        fakturaadresse.setCellValueFactory(new PropertyValueFactory<>("fakturaadresse"));
        forsikringsnummer.setCellValueFactory(new PropertyValueFactory<>("forsikringsnummer"));
        antallForsikringer.setCellValueFactory(new PropertyValueFactory<>("antallForsikringer"));

        tableView.getItems().setAll(Kunderegister.getKundeliste());
    }
}
