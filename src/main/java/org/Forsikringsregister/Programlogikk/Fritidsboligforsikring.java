package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;

public class Fritidsboligforsikring extends Husforsikring implements Serializable {

    private String forsikringstype = "Fritidsboligforsikring";
    public Fritidsboligforsikring(int arligPremie,
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
          super(arligPremie,
                forsikringsbelop,
                opprettetDato,
                betingelser,
                adresse,
                byggear,
                boligtype,
                byggemateriale,
                standard,
                kvadratmeter,
                forsikringsbelopBygning,
                forsikringsbelopInnbo);
    }

    @Override
    public String getForsikringstype() { return forsikringstype; }

    @Override
    public String toCsv(){
        return String.format("%Fritidsboligforsikring;s;%s;%s;%s;%s;%s;%d;%d;%d",
                super.toCsv(),getAdresse(), getByggear().toString(),getBoligtype(),getByggemateriale(),
                getStandard(),getKvadratmeter(),getForsikringsbelopBygning(),getForsikringsbelopInnbo());
    }
}
