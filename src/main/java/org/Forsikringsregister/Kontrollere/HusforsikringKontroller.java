package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class HusforsikringKontroller extends Kontroller{

    private Kunde kunde;
    public HusforsikringKontroller(Kunde kunde){
        this.kunde=kunde;
    }
    public Kunde getKunde(){return this.kunde;}

    @FXML private TextField arligPremie;    @FXML private TextField belop;

    @FXML private TextField byggear;        @FXML private TextField materiale;

    @FXML private TextField kvadratmeter;   @FXML private TextField innboBelop;

    @FXML private TextField adresse;        @FXML private TextField boligType;

    @FXML private TextField standard;       @FXML private TextField bygningBelop;

    @FXML private DatePicker dato;          @FXML private TextArea betingelser;

    @FXML private CheckBox iDag;            @FXML private Button lagre;

    @FXML private Button avbryt;

    @FXML
    void iDag (ActionEvent event){
        if(iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt (ActionEvent event){
        Stage HusForsikring = (Stage) avbryt.getScene().getWindow();
        HusForsikring.close();
    }

    @FXML
    void lagre (ActionEvent event) {
        LocalDate dato;
        if (iDag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = this.dato.getValue();
        }
        /*
        Husforsikring husforsikring = new Husforsikring(arligPremie.getText(), dato, Belop.getText(), Byggear.getText(),
                Materiale.getText(), Kvadratmeter.getText(), InnboBelop.getText(), Adresse.getText(), BoligType.getText(),
                Standard.getText(), BygningBelop.getText(), Betingelser.getText());
        Husforsikring.nyHusforsikring(husforsikring);
        */
    }
    public void initialize(){
    }
}
