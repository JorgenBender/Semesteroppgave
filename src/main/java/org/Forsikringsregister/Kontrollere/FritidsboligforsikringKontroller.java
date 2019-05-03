package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Fritidsboligforsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class FritidsboligforsikringKontroller extends Kontroller{

    private Kunde kunde;

    public FritidsboligforsikringKontroller(Kunde kunde) {
        this.kunde = kunde;
    }

    public Kunde getKunde() {
        return this.kunde;
    }

    @FXML
    private TextField arligPremie;            @FXML private TextField belop;

    @FXML private TextField byggear;          @FXML private TextField materiale;

    @FXML private TextField kvadratmeter;     @FXML private TextField innboBelop;

    @FXML private TextField adresse;          @FXML private TextField boligType;

    @FXML private TextField standard;         @FXML private TextField bygningBelop;

    @FXML private DatePicker dato;            @FXML private TextArea betingelser;

    @FXML private CheckBox iDag;              @FXML private Button lagre;

    @FXML private Button avbryt;

    @FXML
    void iDag(ActionEvent event) {
        if (iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt(ActionEvent event) {
        Stage FritidsboligForsikring = (Stage) avbryt.getScene().getWindow();
        FritidsboligForsikring.close();
    }

    @FXML
    void lagre(ActionEvent event) {
        LocalDate dato;
        if (iDag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = this.dato.getValue();
        }
        try {
            int arligPremieInt = NumberParser.parseNumber(arligPremie.getText(), "Årlig premie er ikke et tall");
            int belopInt = NumberParser.parseNumber(belop.getText(), "Beløp er ikke et tall");
            int kvadratmeterInt = NumberParser.parseNumber(kvadratmeter.getText(), "Kvadratmeter er ikke et tall");
            int bygningBelopInt = NumberParser.parseNumber(bygningBelop.getText(), "Forsikringsbeløp bygning er ikke et tall");
            int innboBelopInt = NumberParser.parseNumber(innboBelop.getText(), "Forsikringsbeløp innbo er ikke et tall");
            Fritidsboligforsikring fritidsboligforsikring = new Fritidsboligforsikring(arligPremieInt,
                    belopInt, dato,
                    betingelser.getText(),
                    adresse.getText(),
                    byggear.getText(),
                    boligType.getText(),
                    materiale.getText(),
                    standard.getText(),
                    kvadratmeterInt,
                    bygningBelopInt,
                    innboBelopInt
            );
            kunde.addForsikring(fritidsboligforsikring);
        }
        catch (NumberFormatException e){
            showAlert(e);
        }
    }

    public void initialize() {
    }
}
