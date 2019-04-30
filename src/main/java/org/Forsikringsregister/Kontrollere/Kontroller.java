package org.Forsikringsregister.Kontrollere;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Kontroller {

    public Stage openStage(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
        Parent root = fxmlLoader.load();
        Image icon = new Image(getClass().getResourceAsStream("../cosmetic/icon.png"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(icon);
        return stage;
    }
}

