package org.openjfx;

public class Reiseforsikring extends Forsikring{

    private String forsikringsOmrade;
    private int forsikringsSum;

    public Reiseforsikring(int arligPremie, int forsikringsbelop, String dato, String betingelser,
                           String forsikringsOmrade, int forsikringsSum) {
        super(arligPremie, forsikringsbelop, dato, betingelser);
        this.forsikringsOmrade = forsikringsOmrade;
        this.forsikringsSum = forsikringsSum;
    }

    public String getForsikringsOmrade() {
        return forsikringsOmrade;
    }

    public int getForsikringsSum() {
        return forsikringsSum;
    }
}
