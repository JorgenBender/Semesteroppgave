package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;  // import the LocalDate class

import java.util.ArrayList;

public class Kunde implements Serializable {
    private static final long serialVersionUID = 2;

    private LocalDate datoKundeforhold;
    private String navn;
    private String fakturaadresse;
    private String forsikringsnummer;

    private ArrayList<Forsikring> forsikringer;
    private ArrayList<Skademelding> skademeldinger;
    private ArrayList<String> ubetalteErstatninger;


    public Kunde(LocalDate datoKundeforhold, String navn, String fakturaadresse, String forsikringsnummer) {
        this.datoKundeforhold = datoKundeforhold;
        this.navn = navn;
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = forsikringsnummer;
    }

    public String getNavn() { return navn; }

    public String getFakturaadresse() { return fakturaadresse; }

    public String getForsikringsnummer() { return forsikringsnummer; }

    public LocalDate getDatoKundeforhold() { return datoKundeforhold; }


    public ArrayList<Forsikring> getForsikringer() { return forsikringer; }

    public ArrayList<Skademelding> getSkademeldinger() { return skademeldinger; }

    public ArrayList<String> getUbetalteErstatninger() { return ubetalteErstatninger; }

    public void addForsikring(Forsikring nyForsikring) { this.forsikringer.add(nyForsikring); }

    public void addSkademelding(Skademelding nySkademelding){ this.skademeldinger.add(nySkademelding); }

    public void addUbetalteErstatninger(String nyErstatning) { this.ubetalteErstatninger.add(nyErstatning); }

    @Override
    public String toString() {
        return String.format("%s ble kunde %s har faktureringsadresse: %s og forsikringsnummer: %s", getNavn(), getDatoKundeforhold().toString(), getFakturaadresse(), getForsikringsnummer());
    }
    public String toCsv() {

        String forsikringer = "";
        for(Forsikring forsikring: getForsikringer()){
            forsikringer += forsikring.toCsv();
        }
        String skademeldinger = "";
        for(Skademelding skademelding: getSkademeldinger()){
            forsikringer += skademelding.toCsv();
        }
        String ubetalteErstatninger = "";
        for(String erstatning: getUbetalteErstatninger()){
            ubetalteErstatninger += erstatning +";";
        }

        return String.format("%s;%s;%s;%s;\n%s;\n%s;\n%s", getNavn(), getDatoKundeforhold().toString(), getFakturaadresse(), getForsikringsnummer(),forsikringer,skademeldinger,ubetalteErstatninger);
    }
}
