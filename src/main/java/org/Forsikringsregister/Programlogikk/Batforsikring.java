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

    @Override
    public String toString(){
        return String.format("Båtforsikring:\n%s Eier: %s\n Regnr: %s\n Type: %s\n Modell:" +
                            "%s\n lengde(fot): %d\n Årsmodell: %s\n Motortype: %s\n Motorkraft: %s",
                            super.toString(),getEier(), getRegistreringsnummer(),getBattype(),getModell(),
                            getLengdeFot(),getArsmodell(),getMotortype(),getMotorstyrke());
    }
    @Override
    public String toCsv(){
        return String.format("Batforsikring;%s;%s;%s;%s;%s;%d;%s;%s;%s",
                super.toCsv(),getEier(), getRegistreringsnummer(),getBattype(),getModell(),
                getLengdeFot(),getArsmodell(),getMotortype(),getMotorstyrke());
    }

}
