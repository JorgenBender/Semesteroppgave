package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;  // import the LocalDate class

public class Husforsikring extends Forsikring implements Serializable {

    private String adresse;
    private LocalDate byggear;
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
                         LocalDate byggear,
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

    public LocalDate getByggear() {
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

    @Override
    public String toString(){
        return String.format("Husforsikring:\n%s Adresse: %s\n Byggeår: %s\n Boligtype: %s\n Byggematriale: %s\n" +
                        "Standar: %s\n Kvadratmeter: %d\n Forsikringsbeløp(hus): %d\n Forsikringsbeløp(innbo): %d",
                        super.toString(),getAdresse(), getByggear().toString(),getBoligtype(),getByggemateriale(),
                        getStandard(),getKvadratmeter(),getForsikringsbelopBygning(),getForsikringsbelopInnbo());
    }

}
