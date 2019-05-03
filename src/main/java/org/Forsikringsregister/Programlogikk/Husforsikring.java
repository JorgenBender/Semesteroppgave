package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;  // import the LocalDate class

public class Husforsikring extends Forsikring implements Serializable {

    private String forsikringstype = "Husforsikring";
    private String adresse;
    private String byggear;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private int kvadratmeter;
    private int forsikringsbelopBygning;
    private int forsikringsbelopInnbo;

    public Husforsikring(int arligPremie,
                         int forsikringsbelop,
                         LocalDate opprettetDato,
                         String betingelser,
                         String adresse,
                         String byggear,
                         String boligtype,
                         String byggemateriale,
                         String standard,
                         int kvadratmeter,
                         int forsikringsbelopBygning,
                         int forsikringsbelopInnbo) {
        super(arligPremie, forsikringsbelop, opprettetDato, betingelser);
        this.adresse = adresse;
        this.byggear = byggear;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.standard = standard;
        this.kvadratmeter = kvadratmeter;
        this.forsikringsbelopBygning = forsikringsbelopBygning;
        this.forsikringsbelopInnbo = forsikringsbelopInnbo;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getByggear() {
        return byggear;
    }

    public String getBoligtype() {
        return boligtype;
    }

    public String getByggemateriale() {
        return byggemateriale;
    }

    public String getStandard() {
        return standard;
    }

    public int getKvadratmeter() {
        return kvadratmeter;
    }

    public int getForsikringsbelopBygning() {
        return forsikringsbelopBygning;
    }

    public int getForsikringsbelopInnbo() {
        return forsikringsbelopInnbo;
    }

    public String getForsikringstype() { return forsikringstype; }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setByggear(String byggear) {
        this.byggear = byggear;
    }

    public void setBoligtype(String boligtype) {
        this.boligtype = boligtype;
    }

    public void setByggemateriale(String byggemateriale) {
        this.byggemateriale = byggemateriale;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public void setKvadratmeter(int kvadratmeter) {
        this.kvadratmeter = kvadratmeter;
    }

    public void setForsikringsbelopBygning(int forsikringsbelopBygning) {
        this.forsikringsbelopBygning = forsikringsbelopBygning;
    }

    public void setForsikringsbelopInnbo(int forsikringsbelopInnbo) {
        this.forsikringsbelopInnbo = forsikringsbelopInnbo;
    }

    @Override
    public String toString(){
        return String.format("Husforsikring:\n%s\n Adresse: %s\n Byggeår: %s\n Boligtype: %s\n Byggematriale: %s\n" +
                        "Standard: %s\nKvadratmeter: %d\nForsikringsbeløp(hus): %d\nForsikringsbeløp(innbo): %d",
                        super.toString(),getAdresse(), getByggear().toString(),getBoligtype(),getByggemateriale(),
                        getStandard(),getKvadratmeter(),getForsikringsbelopBygning(),getForsikringsbelopInnbo());
    }
    @Override
    public String toCsv(){
        return String.format("%s;%s;%s;%s;%s;%s;%s;%d;%d;%d",
                getForsikringstype(),
                super.toCsv(),getAdresse(), getByggear(),getBoligtype(),getByggemateriale(),
                getStandard(),getKvadratmeter(),getForsikringsbelopBygning(),getForsikringsbelopInnbo());
    }

}
