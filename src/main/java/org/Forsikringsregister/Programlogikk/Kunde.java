package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;  // import the LocalDate class

import java.util.ArrayList;

public class Kunde implements Serializable {
    private static final long serialVersionUID = 2;


    private String navn;
    private LocalDate datoKundeforhold;
    private String fakturaadresse;
    private String forsikringsnummer;

    private ArrayList<Forsikring> forsikringer = new ArrayList<>();
    private ArrayList<Skademelding> skademeldinger = new ArrayList<>();
    private ArrayList<String> ubetalteErstatninger = new ArrayList<>();

    private int antallForsikringer = forsikringer.size();


    public Kunde(String navn, LocalDate datoKundeforhold, String fakturaadresse, String forsikringsnummer) {
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

    public void setUbetalteErstatninger(ArrayList<String> ubetalteErstatninger) {
        this.ubetalteErstatninger = ubetalteErstatninger;
    }

    @Override
    public String toString() {
        return String.format("%s ble kunde %s har faktureringsadresse: %s og forsikringsnummer: %s", getNavn(), getDatoKundeforhold().toString(), getFakturaadresse(), getForsikringsnummer());
    }
    public String toCsv() {

        String forsikringer = "";
        for(Forsikring forsikring: getForsikringer()){
            forsikringer += "\nForsikring;" + forsikring.toCsv();
        }
        String skademeldinger = "";
        for(Skademelding skademelding: getSkademeldinger()){
            forsikringer += "\nSkademelding;" + skademelding.toCsv();
        }
        String ubetalteErstatninger = "";
        for(String erstatning: getUbetalteErstatninger()){
            if(ubetalteErstatninger.length()==0){
                ubetalteErstatninger += "\nErstatning;";
            }
            ubetalteErstatninger += erstatning +";";
        }

        return String.format("Kunde;%s;%s;%s;%s;%s;%s;%s", getNavn(), getDatoKundeforhold().toString(), getFakturaadresse(), getForsikringsnummer(),forsikringer,skademeldinger,ubetalteErstatninger);
    }
}
