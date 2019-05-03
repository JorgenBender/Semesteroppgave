package org.Forsikringsregister.Kontrollere;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.Forsikringsregister.IO.*;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HovedSceneKontroller extends Kontroller {

    @FXML
    private Button opprettKunde;
    @FXML
    private Button importerKundeliste;
    @FXML
    private Button fjernKundeliste;
    @FXML
    private Button slettKunde;
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
    private MenuItem lagreCsv;
    @FXML
    private MenuItem lagreJobj;

    @FXML
    void lagreSom(ActionEvent event){
        ExecutorService service = Executors.newSingleThreadExecutor();
        Task<Void> task;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        File file = fileChooser.showSaveDialog(null);
        String extension = "";
        if(file != null) {
            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                extension = file.getName().substring(i + 1);
            }
            switch (extension) {
                case "csv":
                    task = new SkrivCsv(Kunderegister.getKundeliste(), file);
                    service.execute(task);
                    break;
                case "jobj":
                    task = new SkrivJobj(Kunderegister.getKundeliste(), file);
                    service.execute(task);
                    break;
            }
        }
    }
    @FXML
    void importerKundeliste (ActionEvent event) {

        if(Kunderegister.getKundeliste().size() > 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Kunderegister vil bli skrevet over");
            alert.setContentText("Kunderegister vil bli skrevet over og all data vil gå tapt");
            alert.showAndWait();
        }
        importerKundeliste.setDisable(true);
        opprettKunde.setDisable(true);

        ExecutorService service = Executors.newSingleThreadExecutor();
        Task<Void> task;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        File file = fileChooser.showOpenDialog(null);
        String extension = "";
        if(file != null) {
            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                extension = file.getName().substring(i + 1);
            }
            switch (extension) {
                case "csv":
                    task = new InputThread(this::initialize, file, extension);
                    try {
                        service.execute(task);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "jobj":
                    LesJobj jobjLeser = new LesJobj(file);
                    task = new InputThread(this::initialize, file, extension);
                    service.execute(task);
                    break;
            }
        }
    }
    @FXML
    public void selectKunde(MouseEvent event) {
        if (event.getClickCount() == 2 && tableView.getSelectionModel().getSelectedItem() != null) //Checking double click
        {
            try {
                Stage visKunde = openStageSendKunde("../KundeScene.fxml",tableView.getSelectionModel().getSelectedItem());
                visKunde.setTitle(tableView.getSelectionModel().getSelectedItem().getNavn());
                visKunde.showAndWait();
            } catch (IOException e) {
                System.err.println("Cant load new window");
                System.err.println(e.getMessage());
            }

        }
        tableView.getItems().setAll(Kunderegister.getKundeliste());
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
        }
        tableView.getItems().setAll(Kunderegister.getKundeliste());
    }
    @FXML
    void fjernKundeliste(ActionEvent event){
        Kunderegister.setKundeliste(FXCollections.observableArrayList());
        tableView.getItems().setAll(Kunderegister.getKundeliste());
    }
    @FXML
    void slettKunde(ActionEvent event){
        if(tableView.getSelectionModel().getSelectedItem() != null){
            Kunderegister.getKundeliste().remove(tableView.getSelectionModel().getSelectedItem());
            tableView.getItems().setAll(Kunderegister.getKundeliste());
        }
    }

    public void initialize() {
        importerKundeliste.setDisable(false);
        opprettKunde.setDisable(false);
        navn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        datoKundeforhold.setCellValueFactory(new PropertyValueFactory<>("datoKundeforhold"));
        fakturaadresse.setCellValueFactory(new PropertyValueFactory<>("fakturaadresse"));
        forsikringsnummer.setCellValueFactory(new PropertyValueFactory<>("forsikringsnummer"));
        antallForsikringer.setCellValueFactory(new PropertyValueFactory<>("antallForsikringer"));
        tableView.getItems().setAll(Kunderegister.getKundeliste());
    }
}
