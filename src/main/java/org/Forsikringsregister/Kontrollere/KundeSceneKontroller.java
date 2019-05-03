package org.Forsikringsregister.Kontrollere;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Batforsikring;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Skademelding;

import java.io.IOException;

public class KundeSceneKontroller extends Kontroller {

    private Kunde kunde;
    public KundeSceneKontroller(Kunde kunde){
        this.kunde=kunde;
    }
    public Kunde getKunde(){return this.kunde;}

    @FXML
    private Label kundenavn;
    @FXML
    private Label kundeinfo;
    @FXML
    private TableView<Forsikring> tableForsikring;
    @FXML
    private TableColumn<Forsikring, String> forsikringColumn;
    @FXML
    private TableView<Skademelding> tableSkademelding;
    @FXML
    private TableColumn<Skademelding, String> skademeldingColumn;
    @FXML
    private TableView<String> tableErstatning;
    @FXML
    private TableColumn<String, String> erstatningColumn;
    @FXML
    private Label objektInfo;
    @FXML
    private ComboBox<String> nyForsikring;
    @FXML
    private Button nySkademelding;
    @FXML
    private Button nyErstatning;
    @FXML
    private Button slettForsikring;

    @FXML
    public void selectObjekt(MouseEvent event) {

        TableView selectedTable = (TableView) event.getSource();
        if (selectedTable.getSelectionModel().getSelectedItem() != null) {
            for (TableView table : new TableView[]{tableForsikring, tableSkademelding, tableErstatning}) {
                if (table != selectedTable) {
                    table.getSelectionModel().select(null);
                }
            }
            if (event.getClickCount() == 2 && selectedTable == tableForsikring) //Checking double click
            {
                switch (tableForsikring.getSelectionModel().getSelectedItem().getClass().getCanonicalName()) {
                    case "org.Forsikringsregister.Programlogikk.Batforsikring":
                        try {
                            Stage editForsikring = openStageEditForsikring("../Batforsikring.fxml", tableForsikring.getSelectionModel().getSelectedItem());
                            editForsikring.showAndWait();
                        } catch (IOException e) {
                            System.err.println("Cant load new window");
                            System.err.println(e.getMessage() + e.getCause());
                        }
                        break;
                    case "org.Forsikringsregister.Programlogikk.Husforsikring":
                        try {
                            Stage editForsikring = openStageEditForsikring("../Husforsikring.fxml", tableForsikring.getSelectionModel().getSelectedItem());
                            editForsikring.showAndWait();
                        } catch (IOException e) {
                            System.err.println("Cant load new window");
                            System.err.println(e.getMessage() + e.getCause());
                        }
                        break;
                    case "org.Forsikringsregister.Programlogikk.Fritidsboligforsikring":
                        try {
                            Stage editForsikring = openStageEditForsikring("../Fritidsboligforsikring.fxml", tableForsikring.getSelectionModel().getSelectedItem());
                            editForsikring.showAndWait();
                        } catch (IOException e) {
                            System.err.println("Cant load new window");
                            System.err.println(e.getMessage() + e.getCause());
                        }
                        break;
                    case "org.Forsikringsregister.Programlogikk.Reiseforsikring":
                        try {
                            Stage editForsikring = openStageEditForsikring("../Reiseforsikring.fxml", tableForsikring.getSelectionModel().getSelectedItem());
                            editForsikring.showAndWait();
                        } catch (IOException e) {
                            System.err.println("Cant load new window");
                            System.err.println(e.getMessage() + e.getCause());
                        }
                        break;
                }
            }
            if (event.getClickCount() == 2 && selectedTable == tableSkademelding) //Checking double click
            {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Skademelding.fxml"));
                    fxmlLoader.setControllerFactory(c ->{
                        return new EditSkadeMeldingKontroller(tableSkademelding.getSelectionModel().getSelectedItem());
                    });
                    Stage editSkademelding = loadStage(fxmlLoader);
                    editSkademelding.showAndWait();
                } catch (IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage() + e.getCause());
                }
            }
            if (event.getClickCount() == 2 && selectedTable == tableErstatning)
            {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Erstatning.fxml"));
                    fxmlLoader.setControllerFactory(c ->{
                        return new EditErstatningKontroller(tableErstatning.getSelectionModel().getSelectedItem());
                    });
                    Stage editErstatning = loadStage(fxmlLoader);
                    editErstatning.showAndWait();
                } catch (IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage() + e.getCause());
                }
            }
            objektInfo.setText(selectedTable.getSelectionModel().getSelectedItem().toString());
        }
    }
    public void nyForsikring(){

        switch (nyForsikring.getValue()){
            case "Båtforsikring":
                try{
                    Stage stage = openStageSendKunde("../Batforsikring.fxml",getKunde());
                    stage.setTitle("Båtforsikring");
                    stage.showAndWait();
                }
                catch(IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage()+e.getCause());
                }
                break;
            case "Husforsikring":
                try{
                    Stage stage = openStageSendKunde("../Husforsikring.fxml",getKunde());
                    stage.setTitle("Husforsikring");
                    stage.showAndWait();
                }
                catch(IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage());
                }
                break;
            case "Fritidsboligforsikring":
                try{
                    Stage stage = openStageSendKunde("../Fritidsboligforsikring.fxml",getKunde());
                    stage.setTitle("Fritidsboligforsikring");
                    stage.showAndWait();
                }
                catch(IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage());
                }
                break;
            case "Reiseforsikring":
                try{
                    Stage stage = openStageSendKunde("../Reiseforsikring.fxml",getKunde());
                    stage.setTitle("Reiseforsikring");
                    stage.showAndWait();
                }
                catch(IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage());
                }
                break;
        }
        ObservableList<Forsikring> forsikringer = FXCollections.observableArrayList(kunde.getForsikringer());
        tableForsikring.getItems().setAll(forsikringer);
    }
    @FXML
    void nySkademelding(ActionEvent event){
        try{
            Stage stage = openStageSendKunde("../Skademelding.fxml",getKunde());
            stage.setTitle("Skademelding");
            stage.showAndWait();
        }
        catch(IOException e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
        }
        ObservableList<Skademelding> skademeldinger = FXCollections.observableArrayList(kunde.getSkademeldinger());
        tableSkademelding.getItems().setAll(skademeldinger);
    }

    @FXML
    void nyErstatning(ActionEvent event){
        try{
            Stage stage = openStageSendKunde("../Erstatning.fxml",getKunde());
            stage.setTitle("Erstatning");
            stage.showAndWait();
        }
        catch(IOException e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());
        }
        ObservableList<String> erstatninger = FXCollections.observableArrayList(kunde.getUbetalteErstatninger());
        tableErstatning.getItems().setAll(erstatninger);
    }
    @FXML
    void  slettObjekt(ActionEvent event){
        Object obj = null;
        for(TableView table: new TableView[]{tableForsikring,tableSkademelding,tableErstatning}){
            if(table.getSelectionModel().getSelectedItem() != null){
                obj = table.getSelectionModel().getSelectedItem();
                switch (table.getId()){
                    case "forsikringer":
                        kunde.removeForsikring((Forsikring) obj);
                        break;
                    case "skademeldinger":
                        kunde.getSkademeldinger().remove(obj);
                        break;
                    case "erstatninger":
                        kunde.getUbetalteErstatninger().remove(obj);
                        break;
                }
            }
        }
        objektInfo.setText("");
        initialize();
    }


    public void initialize(){

        kundeinfo.setText(kunde.toString());
        kundenavn.setText(kunde.getNavn());
        nyForsikring.getItems().addAll(
                "Båtforsikring",
                    "Husforsikring",
                    "Fritidsboligforsikring",
                    "Reiseforsikring");
        nyForsikring.setOnAction(Event -> nyForsikring());

        forsikringColumn.setCellValueFactory(new PropertyValueFactory<>("forsikringstype"));
        ObservableList<Forsikring> forsikringer = FXCollections.observableArrayList(kunde.getForsikringer());
        tableForsikring.getItems().setAll(forsikringer);

        skademeldingColumn.setCellValueFactory(new PropertyValueFactory<>("skadeType"));
        ObservableList<Skademelding> skademeldinger = FXCollections.observableArrayList(kunde.getSkademeldinger());
        tableSkademelding.getItems().setAll(skademeldinger);

        erstatningColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        ObservableList<String> erstatninger = FXCollections.observableArrayList(kunde.getUbetalteErstatninger());
        tableErstatning.getItems().setAll(erstatninger);
    }
}
