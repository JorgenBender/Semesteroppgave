package org.openjfx;

public class Batforsikring extends Forsikring {
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
                         String dato,
                         String betingelser,
                         String eier,
                         String registreringsnummer,
                         String battype,
                         String modell,
                         int lengdeFot,
                         String arsmodell,
                         String motortype,
                         String motorstyrke) {
        super(arligPremie, forsikringsbelop, dato, betingelser);
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
}
