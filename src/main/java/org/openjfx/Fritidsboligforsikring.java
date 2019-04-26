package org.openjfx;

import java.io.Serializable;
import java.time.LocalDate;

public class Fritidsboligforsikring extends Husforsikring implements Serializable {

    public Fritidsboligforsikring(int arligPremie,
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
}
