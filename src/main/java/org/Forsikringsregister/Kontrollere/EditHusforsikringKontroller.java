package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Fritidsboligforsikring;
import org.Forsikringsregister.Programlogikk.Husforsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class EditHusforsikringKontroller extends Kontroller {

    private Husforsikring husforsikring;

    public EditHusforsikringKontroller(Forsikring forsikring) {
        this.husforsikring = (Husforsikring)forsikring;
    }

    public Husforsikring getHusforsikring() {
        return this.husforsikring;
    }

    @FXML private Label tittel;
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
        try {
            int arligPremieInt = NumberParser.parseNumber(arligPremie.getText(), "Årlig premie er ikke et tall");
            int belopInt = NumberParser.parseNumber(belop.getText(), "Beløp er ikke et tall");
            int kvadratmeterInt = NumberParser.parseNumber(kvadratmeter.getText(), "Kvadratmeter er ikke et tall");
            int bygningBelopInt = NumberParser.parseNumber(bygningBelop.getText(), "Forsikringsbeløp bygning er ikke et tall");
            int innboBelopInt = NumberParser.parseNumber(innboBelop.getText(), "Forsikringsbeløp innbo er ikke et tall");
            this.husforsikring.setForsikringsbelop(belopInt);
            this.husforsikring.setOpprettetDato(dato);
            this.husforsikring.setBetingelser(betingelser.getText());
            this.husforsikring.setAdresse(adresse.getText());
            this.husforsikring.setByggear(byggear.getText());
            this.husforsikring.setBoligtype(boligType.getText());
            this.husforsikring.setByggemateriale(materiale.getText());
            this.husforsikring.setStandard(standard.getText());
            this.husforsikring.setKvadratmeter(kvadratmeterInt);
            this.husforsikring.setForsikringsbelopBygning(bygningBelopInt);
            this.husforsikring.setForsikringsbelopInnbo(innboBelopInt);
        }
        catch (NumberFormatException e) {
            showAlert(e);
        }
    }
    public void initialize() {
        arligPremie.setText(""+this.husforsikring.getArligPremie());
        belop.setText(""+this.husforsikring.getForsikringsbelop());
        byggear.setText(this.husforsikring.getByggear());
        materiale.setText(this.husforsikring.getByggemateriale());
        kvadratmeter.setText(""+this.husforsikring.getKvadratmeter());
        adresse.setText(this.husforsikring.getAdresse());
        boligType.setText(this.husforsikring.getBoligtype());
        standard.setText(this.husforsikring.getStandard());
        dato.setValue(this.husforsikring.getOpprettetDato());
        betingelser.setText(this.husforsikring.getBetingelser());
        bygningBelop.setText(""+this.husforsikring.getForsikringsbelopBygning());
        innboBelop.setText(""+this.husforsikring.getForsikringsbelopInnbo());
    }
}

