package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class HovedSceneKontroller{

    @FXML
    private Button k;

    @FXML
    private Button register;

    @FXML
    void action(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../OpprettKunde.fxml"));
            Parent root = fxmlLoader.load();
            Stage regKunde = new Stage();
            regKunde.setScene(new Scene(root));
            regKunde.initModality(Modality.APPLICATION_MODAL);
            regKunde.showAndWait();
        }
        catch (Exception e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());


        }

    }
    public void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ImporterKundeRegister.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        }
        catch (Exception e){
            System.err.println("Cant load new window");
            System.err.println(e.getMessage());

        }
    }
}
