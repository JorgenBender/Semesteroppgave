package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.Forsikringsregister.NumberParser;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Skademelding;

import java.time.LocalDate;

public class EditSkadeMeldingKontroller extends Kontroller{

    private Skademelding skademelding;
    public EditSkadeMeldingKontroller(Skademelding skademelding){
        this.skademelding = skademelding;
    }
    public Skademelding getSkademelding(){return this.skademelding;}

    @FXML private TextField skadeNummer;    @FXML private TextField takseringsBelop;

    @FXML private TextField type;           @FXML private DatePicker dato;

    @FXML private TextArea beskrivelse;     @FXML private TextArea kontaktInfo;

    @FXML private CheckBox iDag;            @FXML private Button lagre;

    @FXML private Button avbryt;            @FXML private Label tittel;

    @FXML
    void IDagChecked (ActionEvent event){
        if(iDag.isSelected()) {
            dato.setValue(LocalDate.now());
        }
    }

    @FXML
    void avbryt (ActionEvent event){
        Stage Skademelding = (Stage) avbryt.getScene().getWindow();
        Skademelding.close();
    }

    @FXML
    void lagre(ActionEvent event){
        LocalDate dato;
        if (iDag.isSelected()) {
            dato = LocalDate.now();
        } else {
            dato = this.dato.getValue();
        }
        try {
            int takseringsbelopInt = NumberParser.parseNumber(takseringsBelop.getText(), "Takseringsbeløp er ikke et tall");
            this.skademelding.setSkadeDato(dato);
            this.skademelding.setSkadenummer(skadeNummer.getText());
            this.skademelding.setSkadeType(type.getText());
            this.skademelding.setSkadeBeskrivelse(beskrivelse.getText());
            this.skademelding.setVitner_kontaktinformasjon(kontaktInfo.getText());
            this.skademelding.setTakseringsbelop(takseringsbelopInt);
            this.skademelding.setUtbetalt_erstatningsbelop(0);

        }
        catch (NumberFormatException e){
            showAlert(e);
        }
        Stage stage = (Stage)lagre.getScene().getWindow();
        stage.close();
    }
    public void initialize(){
        tittel.setText("Rediger Skademelding");
        skadeNummer.setText(this.skademelding.getSkadenummer());
        beskrivelse.setText(this.skademelding.getSkadeBeskrivelse());
        takseringsBelop.setText(""+this.skademelding.getTakseringsbelop());
        dato.setValue(this.skademelding.getSkadeDato());
        type.setText(this.skademelding.getSkadeType());
        kontaktInfo.setText(this.skademelding.getVitner_kontaktinformasjon());
        TextField utbetaltBelop = new TextField();
        utbetaltBelop.setPromptText("Utbetalt Erstatningsbeløp");
    }
}
