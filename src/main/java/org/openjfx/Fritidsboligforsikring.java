package org.openjfx;

public class Fritidsboligforsikring extends Husforsikring {

    public Fritidsboligforsikring(int arligPremie,
                                  int forsikringsbelop,
                                  String dato,
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
                dato,
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
