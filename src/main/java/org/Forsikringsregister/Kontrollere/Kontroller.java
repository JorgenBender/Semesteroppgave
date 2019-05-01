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
        Stage stage = loadStage(fxmlLoader);
        return stage;
    }

    public Stage loadStage(FXMLLoader loader) throws IOException {
        Parent root = loader.load();
        Image icon = new Image(getClass().getResourceAsStream("../cosmetic/icon.png"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../cosmetic/styles.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(icon);
        return stage;
    }

}

