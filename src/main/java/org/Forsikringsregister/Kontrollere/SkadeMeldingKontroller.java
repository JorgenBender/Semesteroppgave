package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Skademelding;

import java.time.LocalDate;

public class SkadeMeldingKontroller extends Kontroller{

    private Kunde kunde;
    public SkadeMeldingKontroller(Kunde kunde){
        this.kunde=kunde;
    }
    public Kunde getKunde(){return this.kunde;}

    @FXML private TextField skadeNummer;    @FXML private TextField takseringsBelop;

    @FXML private TextField type;           @FXML private DatePicker dato;

    @FXML private TextArea beskrivelse;     @FXML private TextArea kontaktInfo;

    @FXML private CheckBox iDag;            @FXML private Button lagre;

    @FXML private Button avbryt;

    @FXML
    void IDagChecked (ActionEvent event){
        if(iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbrytScene (ActionEvent event){
        Stage Skademelding = (Stage) avbryt.getScene().getWindow();
        Skademelding.close();
    }

    @FXML
    void nyLagring(ActionEvent event){
        LocalDate dato;
        if (iDag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = this.dato.getValue();
        }
        try {
            int takseringsbelopInt = NumberParser.parseNumber(takseringsBelop.getText(), "Takseringsbeløp er ikke et tall");
            Skademelding skademelding = new Skademelding(dato, skadeNummer.getText(), type.getText(), beskrivelse.getText(), kontaktInfo.getText(), takseringsbelopInt);
            kunde.addSkademelding(skademelding);
        }
        catch (NumberFormatException e){
            showAlert(e);
        }
    }
}
