package org.Forsikringsregister.Kontrollere;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Batforsikring;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Kunde;
import java.io.IOException;

public class Kontroller {

    Stage openStage(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
        return loadStage(fxmlLoader);

    }

    Stage openStageSendKunde(String resource, Kunde kunde) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));

        switch(resource){
            case "../KundeScene.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new KundeSceneKontroller(kunde);});
                break;
            case "../Batforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new BatforsikringKontroller(kunde);});
                break;
            case "../Husforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new HusforsikringKontroller(kunde);});
                break;
            case "../Fritidsboligforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new FritidsboligforsikringKontroller(kunde);});
                break;
            case "../Reiseforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new ReiseforsikringKontroller(kunde);});
                break;
            case "../Skademelding.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new SkadeMeldingKontroller(kunde);});
                break;
            case "../Erstatning.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new ErstatningKontroller(kunde);});
                break;
            }
        return loadStage(fxmlLoader);
    }
    Stage openStageEditForsikring(String resource, Forsikring forsikring) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));

        switch(resource){
            case "../Batforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new EditBatforsikringKontroller(forsikring);});
                break;
            case "../Husforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new EditHusforsikringKontroller(forsikring);});
                break;
            case "../Fritidsboligforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new EditFritidsboligforsikringKontroller(forsikring);});
                break;
            case "../Reiseforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new EditReiseforsikringKontroller(forsikring);});
                break;
        }
        return loadStage(fxmlLoader);
    }

    Stage loadStage(FXMLLoader loader) throws IOException {
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
    void showAlert(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(e.getClass().getCanonicalName());
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

}

