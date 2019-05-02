package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Husforsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class HusforsikringKontroller extends Kontroller {

    private Kunde kunde;

    public HusforsikringKontroller(Kunde kunde) {
        this.kunde = kunde;
    }

    public Kunde getKunde() {
        return this.kunde;
    }

    @FXML
    private TextField arligPremie;
    @FXML
    private TextField belop;

    @FXML
    private TextField byggear;
    @FXML
    private TextField materiale;

    @FXML
    private TextField kvadratmeter;
    @FXML
    private TextField innboBelop;

    @FXML
    private TextField adresse;
    @FXML
    private TextField boligType;

    @FXML
    private TextField standard;
    @FXML
    private TextField bygningBelop;

    @FXML
    private DatePicker dato;
    @FXML
    private TextArea betingelser;

    @FXML
    private CheckBox iDag;
    @FXML
    private Button lagre;

    @FXML
    private Button avbryt;

    @FXML
    void iDag(ActionEvent event) {
        if (iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt(ActionEvent event) {
        Stage HusForsikring = (Stage) avbryt.getScene().getWindow();
        HusForsikring.close();
    }

    @FXML
    void lagre(ActionEvent event) {
        LocalDate dato;
        if (iDag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = this.dato.getValue();
        }
        int arligPremieInt = NumberParser.parseNumber(arligPremie.getText(), "Årlig premie er ikke et tall");
        int belopInt = NumberParser.parseNumber(belop.getText(), "Beløp er ikke et tall");
        int kvadratmeterInt = NumberParser.parseNumber(kvadratmeter.getText(), "Kvadratmeter er ikke et tall");
        int bygningBeløpInt = NumberParser.parseNumber(bygningBelop.getText(), "Forsikringsbeløp bygning er ikke et tall");
        int innboBeløpInt = NumberParser.parseNumber(innboBelop.getText(), "Forsikringsbeløp innbo er ikke et tall");


        Husforsikring husforsikring = new Husforsikring(arligPremieInt,
                                                        belopInt, dato,
                                                        betingelser.getText(),
                                                        adresse.getText(),
                                                        byggear.getText(),
                                                        boligType.getText(),
                                                        materiale.getText(),
                                                        standard.getText(),
                                                        kvadratmeterInt,
                                                        bygningBeløpInt,
                                                        innboBeløpInt
        );

        kunde.addForsikring(husforsikring);
    }

    public void initialize() {
    }
}

