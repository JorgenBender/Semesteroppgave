package org.Forsikringsregister.Kontrollere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
    private TableView<Forsikring> tableView;
    @FXML
    private TableColumn<Forsikring, String> forsikringstype;
    @FXML
    private Label forsikringsinfo;
    @FXML
    private ComboBox<String> nyForsikring;

    @FXML
    public void selectForsikring(MouseEvent event) {
        try{
            forsikringsinfo.setText(tableView.getSelectionModel().getSelectedItem().toString());
            }
        catch(NullPointerException e){
            //Hvis man trykker på et tom forsikring kommer NullPointerException
            }
    }
    public void nyForsikring(){

        switch (nyForsikring.getValue()){
            case "Båtforsikring":
                try{
                    Stage stage = openStageSendKunde("../Batforsikring.fxml",getKunde());
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
                    stage.showAndWait();
                }
                catch(IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage());
                }
                break;
            case "Rieseforsikring":
                try{
                    Stage stage = openStageSendKunde("../Reiseforsikring.fxml",getKunde());
                    stage.showAndWait();
                }
                catch(IOException e){
                    System.err.println("Cant load new window");
                    System.err.println(e.getMessage());
                }
                break;
        }
    }

    public void initialize(){

        kundeinfo.setText(kunde.toString());
        kundenavn.setText(kunde.getNavn());
        nyForsikring.getItems().addAll(
                "Båtforsikring",
                    "Husforsikring",
                    "Fritidsboligforsikrign",
                    "Reiseforsikring");
        nyForsikring.setOnAction(Event -> nyForsikring());

        forsikringstype.setCellValueFactory(new PropertyValueFactory<>("forsikringstype"));
        ObservableList<Forsikring> forsikringer = FXCollections.observableArrayList(kunde.getForsikringer());
        tableView.getItems().setAll(forsikringer);
    }
}
