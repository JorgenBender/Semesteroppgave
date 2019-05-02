package org.Forsikringsregister.Kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
        }/*
        Batforsikring batforsikring = new Batforsikring(arligPremie.getText(), belop.getText(), dato,
                betingelser.getText(), eier.getText(), regNummer.getText(), battype.getText(), modell.getText(),
                lengdeFot.getText(), arsmodell.getText(), motorType.getText(), motorStyrke.getText());
        Batforsikring.addForsikring(batforsikring);
        */}

    public void initialize(){
    }
}
