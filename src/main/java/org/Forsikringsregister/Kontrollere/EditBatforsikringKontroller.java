package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Batforsikring;
import org.Forsikringsregister.Programlogikk.Forsikring;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.time.LocalDate;

public class EditBatforsikringKontroller extends Kontroller{

    private Batforsikring batforsikring;
    public EditBatforsikringKontroller(Forsikring forsikring) { this.batforsikring = (Batforsikring)forsikring;}
    public Batforsikring getKunde(){return this.batforsikring;}

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
        Stage BatForsikring= (Stage) avbryt.getScene().getWindow();
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
            this.batforsikring.setArligPremie(arligPremieInt);
            this.batforsikring.setForsikringsbelop(belopInt);
            this.batforsikring.setOpprettetDato(dato);
            this.batforsikring.setBetingelser(betingelser.getText());
            this.batforsikring.setEier(eier.getText());
            this.batforsikring.setRegistreringsnummer(regNummer.getText());
            this.batforsikring.setBattype(battype.getText());
            this.batforsikring.setModell(modell.getText());
            this.batforsikring.setLengdeFot(lengdeFotInt);
            this.batforsikring.setArsmodell(arsmodell.getText());
            this.batforsikring.setMotortype(motorType.getText());
            this.batforsikring.setMotorstyrke(motorStyrke.getText());
        }
        catch (NumberFormatException e){
            showAlert(e);
        }
        Stage stage = (Stage)lagre.getScene().getWindow();
        stage.close();
    }
    public void initialize(){
        tittel.setText("Rediger Båtforsikring");
        arligPremie.setText(""+batforsikring.getArligPremie());
        belop.setText(""+batforsikring.getForsikringsbelop());
        regNummer.setText(batforsikring.getRegistreringsnummer());
        lengdeFot.setText(""+batforsikring.getLengdeFot());
        eier.setText(batforsikring.getEier());
        battype.setText(batforsikring.getBattype());
        arsmodell.setText(batforsikring.getArsmodell());
        motorType.setText(batforsikring.getMotortype());
        motorStyrke.setText(batforsikring.getMotorstyrke());
        modell.setText(batforsikring.getModell());
        dato.setValue(batforsikring.getOpprettetDato());
        betingelser.setText(batforsikring.getBetingelser());
    }
}
