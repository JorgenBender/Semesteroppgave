package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;

public class Batforsikring extends Forsikring implements Serializable {

    private String forsikringstype = "Batforsikring";
    private String eier;
    private String registreringsnummer;
    private String battype;
    private String modell;
    private int lengdeFot;
    private String arsmodell;
    private String motortype;
    private String motorstyrke;

    public Batforsikring(int arligPremie,
                         int forsikringsbelop,
                         LocalDate opprettetDato,
                         String betingelser,
                         String eier,
                         String registreringsnummer,
                         String battype,
                         String modell,
                         int lengdeFot,
                         String arsmodell,
                         String motortype,
                         String motorstyrke) {
        super(arligPremie, forsikringsbelop, opprettetDato, betingelser);
        this.eier = eier;
        this.registreringsnummer = registreringsnummer;
        this.battype = battype;
        this.modell = modell;
        this.lengdeFot = lengdeFot;
        this.arsmodell = arsmodell;
        this.motortype = motortype;
        this.motorstyrke = motorstyrke;
    }

    public String getEier() {
        return eier;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public String getBattype() {
        return battype;
    }

    public String getModell() {
        return modell;
    }

    public int getLengdeFot() {
        return lengdeFot;
    }

    public String getArsmodell() {
        return arsmodell;
    }

    public String getMotortype() {
        return motortype;
    }

    public String getMotorstyrke() {
        return motorstyrke;
    }

    public String getForsikringstype() { return forsikringstype; }

    public void setEier(String eier) {
        this.eier = eier;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public void setBattype(String battype) {
        this.battype = battype;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setLengdeFot(int lengdeFot) {
        this.lengdeFot = lengdeFot;
    }

    public void setArsmodell(String arsmodell) {
        this.arsmodell = arsmodell;
    }

    public void setMotortype(String motortype) {
        this.motortype = motortype;
    }

    public void setMotorstyrke(String motorstyrke) {
        this.motorstyrke = motorstyrke;
    }

    @Override
    public String toString(){
        return String.format("Båtforsikring:\n%s\nEier: %s\nRegnr: %s\nType: %s\nModell: " +
                            "%s\nlengde(fot): %d\nÅrsmodell: %s\nMotortype: %s\nMotorkraft: %s",
                            super.toString(),getEier(), getRegistreringsnummer(),getBattype(),getModell(),
                            getLengdeFot(),getArsmodell(),getMotortype(),getMotorstyrke());
    }
    @Override
    public String toCsv(){
        return String.format("%s;%s;%s;%s;%s;%s;%d;%s;%s;%s",
                getForsikringstype(),
                super.toCsv(),getEier(), getRegistreringsnummer(),getBattype(),getModell(),
                getLengdeFot(),getArsmodell(),getMotortype(),getMotorstyrke());
    }

}
