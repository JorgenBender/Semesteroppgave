package org.openjfx;

import java.time.LocalDate;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import java.util.ArrayList;

public class Kunde {

    private DateTimeFormatter mittFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate datoKundeforhold;
    private String navn;
    private String fakturaadresse;
    private String forsikringsnummer;
    private ArrayList<Forsikring> forsikringer;
    private ArrayList<Skademelding> skademeldinger;
    private ArrayList<String> ubetalteErstatninger;

    public Kunde(String datoKundeforhold, String navn, String fakturaadresse, String forsikringsnummer) {
        this.datoKundeforhold = LocalDate.parse(datoKundeforhold, mittFormat);
        this.navn = navn;
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = forsikringsnummer;
    }

    public LocalDate getDatoKundeforhold() {
        return datoKundeforhold;
    }

    public String getNavn() {
        return navn;
    }

    public String getFakturaadresse() {
        return fakturaadresse;
    }

    public String getForsikringsnummer() {
        return forsikringsnummer;
    }

    public ArrayList<Forsikring> getForsikringer() {
        return forsikringer;
    }

    public ArrayList<Skademelding> getSkademeldinger() {
        return skademeldinger;
    }

    public ArrayList<String> getUbetalteErstatninger() {
        return ubetalteErstatninger;
    }
}
