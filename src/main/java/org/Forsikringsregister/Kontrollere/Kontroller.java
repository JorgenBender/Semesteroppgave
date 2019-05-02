package org.Forsikringsregister.Kontrollere;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.Forsikringsregister.Exceptions.InvalidFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;
import java.io.IOException;

public class Kontroller {

    public Stage openStage(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
        return loadStage(fxmlLoader);

    }

    public Stage openStageSendKunde(String resource, Kunde kunde) throws IOException {
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
                fxmlLoader.setControllerFactory(c ->{ return new Fritidsboligforsikringkontroller(kunde);});
                break;
            case "../Reiseforsikring.fxml":
                fxmlLoader.setControllerFactory(c ->{ return new ReiseforsikringKontroller(kunde);});
                break;
            }
        return loadStage(fxmlLoader);
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
    private static int parseNumber(String str, String errorMessage) throws InvalidFormatException {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(errorMessage);
        }

        return number;
    }

}

