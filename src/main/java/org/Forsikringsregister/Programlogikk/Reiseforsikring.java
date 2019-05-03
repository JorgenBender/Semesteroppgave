package org.Forsikringsregister.Programlogikk;

import org.Forsikringsregister.Programlogikk.Forsikring;

import java.io.Serializable;
import java.time.LocalDate;

public class Reiseforsikring extends Forsikring implements Serializable {

    private String forsikringstype = "Reiseforsikring";
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

    public String getForsikringstype() { return forsikringstype; }

    public void setForsikringsOmrade(String forsikringsOmrade) {
        this.forsikringsOmrade = forsikringsOmrade;
    }

    public void setForsikringsSum(int forsikringsSum) {
        this.forsikringsSum = forsikringsSum;
    }

    @Override
    public String toString(){
        return String.format("Reiseforsikring:\n%s Forsikringsområde: %s\n Forsikringssum: %d",super.toString(),getForsikringsOmrade(),getForsikringsSum());
    }
    @Override
    public String toCsv(){
        return String.format("&s;%s;%s;%d",getForsikringstype(),super.toCsv(),getForsikringsOmrade(),getForsikringsSum());
    }

}
