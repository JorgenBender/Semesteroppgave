package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Batforsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class BatforsikringKontroller extends Kontroller{

    private Kunde kunde;
    public BatforsikringKontroller(Kunde kunde){
        this.kunde=kunde;
    }
    public Kunde getKunde(){return this.kunde;}

    @FXML private TextField arligPremie;    @FXML private TextField belop;

    @FXML private TextField regNummer;      @FXML private TextField lengdeFot;

    @FXML private TextField eier;           @FXML private TextField battype;

    @FXML private TextField arsmodell;      @FXML private TextField motorType;

    @FXML private TextField motorStyrke;    @FXML private TextField modell;

    @FXML private DatePicker dato;          @FXML private TextArea betingelser;

    @FXML private CheckBox iDag;            @FXML private Button lagre;

    @FXML private Button avbryt;            @FXML private Label tittel;



    @FXML
    void iDag (ActionEvent event){
        if(iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt (ActionEvent event){
        Stage BatForsikring = (Stage) avbryt.getScene().getWindow();
        BatForsikring.close();
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
            int lengdeFotInt = NumberParser.parseNumber(lengdeFot.getText(), "Lengde er ikke et tall");
            Batforsikring batforsikring = new Batforsikring(
                    arligPremieInt,
                    belopInt, dato,
                    betingelser.getText(),
                    eier.getText(),
                    regNummer.getText(),
                    battype.getText(),
                    modell.getText(),
                    lengdeFotInt,
                    arsmodell.getText(),
                    motorType.getText(),
                    motorStyrke.getText());
            kunde.addForsikring(batforsikring);
        }
        catch (NumberFormatException e){
            showAlert(e);
        }
        Stage stage = (Stage)lagre.getScene().getWindow();
        stage.close();
    }

    public void initialize(){
    }
}
