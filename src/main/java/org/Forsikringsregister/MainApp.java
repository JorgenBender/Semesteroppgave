package org.Forsikringsregister;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*String mittNavn = "Per";
        String dittNavn = mittNavn;
        mittNavn = "Ole";
        System.out.println(mittNavn + dittNavn);*/

        Parent root = FXMLLoader.load(getClass().getResource("HovedScene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("cosmetic/styles.css").toExternalForm());

        stage.setTitle("Bender Forsikring");
        Image icon = new Image(getClass().getResourceAsStream("cosmetic/icon.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

