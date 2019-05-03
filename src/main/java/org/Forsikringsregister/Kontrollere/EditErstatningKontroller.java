package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;

public class EditErstatningKontroller extends Kontroller{

    private String enErstatning;
    private Kunde kunde;
    public EditErstatningKontroller(String string, Kunde kunde){
        this.enErstatning = string;
        this.kunde = kunde;
    }
    public String getErstatning(){return this.enErstatning;}

    @FXML
    private TextArea erstatning;
    @FXML
    private Button lagre;
    @FXML
    private  Button avbryt;

    @FXML
    void lagre(ActionEvent event){
        kunde.getUbetalteErstatninger().remove(this.enErstatning);
        kunde.addUbetalteErstatninger(erstatning.getText());
        erstatning.getText();
        Stage stage = (Stage)lagre.getScene().getWindow();
        stage.close();
    }
    @FXML
    void avbryt(ActionEvent event){
        Stage stage = (Stage)avbryt.getScene().getWindow();
        stage.close();
    }
    public void initialize(){
        erstatning.setText(enErstatning);
    }
}
