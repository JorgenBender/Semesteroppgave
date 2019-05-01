package org.Forsikringsregister.Kontrollere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;

public class KundeSceneKontroller extends Kontroller {

    Kunde kunde;
    public KundeSceneKontroller(Kunde kunde){
        this.kunde=kunde;
    }

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
    private Button nyForsikring;

    @FXML
    public void selectForsikring(MouseEvent event) {
        if (event.getClickCount() == 1) //Checking double click
        {
            try{
                forsikringsinfo.setText(tableView.getSelectionModel().getSelectedItem().toString());
            }
            catch(NullPointerException e){

            }

        }
    }

    public void initialize(){

        kundeinfo.setText(kunde.toString());
        kundenavn.setText(kunde.getNavn());

        forsikringstype.setCellValueFactory(new PropertyValueFactory<>("forsikringstype"));
        ObservableList<Forsikring> forsikringer = FXCollections.observableArrayList(kunde.getForsikringer());
        tableView.getItems().setAll(forsikringer);
    }
}
