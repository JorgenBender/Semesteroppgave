package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Fritidsboligforsikring;

import java.time.LocalDate;

public class EditFritidsboligforsikringKontroller extends Kontroller {

    private Fritidsboligforsikring fritidsboligforsikring;

    public EditFritidsboligforsikringKontroller(Forsikring forsikring) {
        this.fritidsboligforsikring = (Fritidsboligforsikring) forsikring;
    }

    public Fritidsboligforsikring getFritidsboligforsikring() {
        return this.fritidsboligforsikring;
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
        Stage fritidsboligforsikring = (Stage) avbryt.getScene().getWindow();
        fritidsboligforsikring.close();
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
            this.fritidsboligforsikring.setForsikringsbelop(belopInt);
            this.fritidsboligforsikring.setOpprettetDato(dato);
            this.fritidsboligforsikring.setBetingelser(betingelser.getText());
            this.fritidsboligforsikring.setAdresse(adresse.getText());
            this.fritidsboligforsikring.setByggear(byggear.getText());
            this.fritidsboligforsikring.setBoligtype(boligType.getText());
            this.fritidsboligforsikring.setByggemateriale(materiale.getText());
            this.fritidsboligforsikring.setStandard(standard.getText());
            this.fritidsboligforsikring.setKvadratmeter(kvadratmeterInt);
            this.fritidsboligforsikring.setForsikringsbelopBygning(bygningBelopInt);
            this.fritidsboligforsikring.setForsikringsbelopInnbo(innboBelopInt);
        }
        catch (NumberFormatException e) {
            showAlert(e);
        }
    }
    public void initialize() {
        arligPremie.setText(""+this.fritidsboligforsikring.getArligPremie());
        belop.setText(""+this.fritidsboligforsikring.getForsikringsbelop());
        byggear.setText(this.fritidsboligforsikring.getByggear());
        materiale.setText(this.fritidsboligforsikring.getByggemateriale());
        kvadratmeter.setText(""+this.fritidsboligforsikring.getKvadratmeter());
        adresse.setText(this.fritidsboligforsikring.getAdresse());
        boligType.setText(this.fritidsboligforsikring.getBoligtype());
        standard.setText(this.fritidsboligforsikring.getStandard());
        dato.setValue(this.fritidsboligforsikring.getOpprettetDato());
        betingelser.setText(this.fritidsboligforsikring.getBetingelser());
        bygningBelop.setText(""+this.fritidsboligforsikring.getForsikringsbelopBygning());
        innboBelop.setText(""+this.fritidsboligforsikring.getForsikringsbelopInnbo());
    }
}

