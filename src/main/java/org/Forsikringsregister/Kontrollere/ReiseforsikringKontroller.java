package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Reiseforsikring;

import java.time.LocalDate;

public class ReiseforsikringKontroller extends Kontroller {

    private Kunde kunde;
    public ReiseforsikringKontroller(Kunde kunde){
        this.kunde=kunde;
    }
    public Kunde getKunde(){return this.kunde;}

    @FXML private TextField arligPremie;    @FXML private TextField belop;

    @FXML private TextField sum;            @FXML private DatePicker dato;

    @FXML private CheckBox iDag;            @FXML private TextArea omrade;

    @FXML private TextArea betingelser;     @FXML private Button lagre;

    @FXML private Button avbryt;

    @FXML
    void iDag (ActionEvent event){
        if(iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt (ActionEvent event){
        Stage ReiseForsikring = (Stage) avbryt.getScene().getWindow();
        ReiseForsikring.close();
    }

    @FXML
    void lagre (ActionEvent event) {
        LocalDate dato;
        if (iDag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = this.dato.getValue();
        }
        try {
            int arligPremieInt = NumberParser.parseNumber(arligPremie.getText(), "Årlig premie er ikke et tall");
            int belopInt = NumberParser.parseNumber(belop.getText(), "Beløp er ikke et tall");
            int sumInt = NumberParser.parseNumber(sum.getText(), "Sum er ikke et tall");

            Reiseforsikring reiseforsikring = new Reiseforsikring(arligPremieInt,
                    belopInt, dato,
                    betingelser.getText(),
                    omrade.getText(),
                    sumInt);
            kunde.addForsikring(reiseforsikring);
        } catch (NumberFormatException e) {
            showAlert(e);
        }
        Stage stage = (Stage)lagre.getScene().getWindow();
        stage.close();
    }
    public void initialize(){
    }
}
