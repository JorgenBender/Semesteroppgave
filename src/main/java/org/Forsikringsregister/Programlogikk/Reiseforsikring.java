package org.Forsikringsregister.Programlogikk;

import org.Forsikringsregister.Programlogikk.Forsikring;

import java.io.Serializable;
import java.time.LocalDate;

public class Reiseforsikring extends Forsikring implements Serializable {

    private String forsikringsOmrade;
    private int forsikringsSum;

    public Reiseforsikring(int arligPremie, int forsikringsbelop, LocalDate opprettetDato, String betingelser,
                           String forsikringsOmrade, int forsikringsSum) {
        super(arligPremie, forsikringsbelop, opprettetDato, betingelser);
        this.forsikringsOmrade = forsikringsOmrade;
        this.forsikringsSum = forsikringsSum;
    }

    public String getForsikringsOmrade() {
        return forsikringsOmrade;
    }

    public int getForsikringsSum() {
        return forsikringsSum;
    }

    @Override
    public String toString(){
        return String.format("Reiseforsikring:\n%s Forsikringsområde: %s\n Forsikringssum: %d",super.toString(),getForsikringsOmrade(),getForsikringsSum());
    }

}
