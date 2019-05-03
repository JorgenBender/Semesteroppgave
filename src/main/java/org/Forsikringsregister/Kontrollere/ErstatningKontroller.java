package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;

public class ErstatningKontroller extends Kontroller{

    private Kunde kunde;
    public ErstatningKontroller(Kunde kunde){
        this.kunde=kunde;
    }
    public Kunde getKunde(){return this.kunde;}

    @FXML
    private TextArea erstatning;
    @FXML
    private Button lagre;
    @FXML
    private  Button avbryt;

    @FXML
    void lagre(ActionEvent event){
        kunde.addUbetalteErstatninger(erstatning.getText());
        Stage stage = (Stage)lagre.getScene().getWindow();
        stage.close();
    }
    @FXML
    void avbryt(ActionEvent event){
        Stage stage = (Stage)avbryt.getScene().getWindow();
        stage.close();
    }

}
