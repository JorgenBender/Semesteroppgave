package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainSceneController {

    public static Kunderegister kunderegister = new Kunderegister();

    public static void setKunderegister(Kunderegister kunderegister) {
        MainSceneController.kunderegister = kunderegister;
    }

    public static Kunderegister getKunderegister() {
        return kunderegister;
    }

    @FXML
    private Label label;
    @FXML
    private Button btn;
    @FXML
    private Button btn2;

    @FXML
    void click(ActionEvent event) {

    }
    public void initialize() {

    }
}
