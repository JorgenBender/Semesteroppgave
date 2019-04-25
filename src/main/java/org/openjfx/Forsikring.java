package org.openjfx;

import java.time.LocalDate;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Forsikring {

    private DateTimeFormatter mittFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private int arligPremie;
    private int forsikringsbelop;
    private LocalDate opprettetDato;
    private String betingelser;

    public Forsikring(int arligPremie, int forsikringsbelop, String dato, String betingelser) {
        this.arligPremie = arligPremie;
        this.forsikringsbelop = forsikringsbelop;
        this.opprettetDato = LocalDate.parse(dato, mittFormat);
        this.betingelser = betingelser;
    }

    public int getArligPremie() {
        return arligPremie;
    }

    public int getForsikringsbelop() {
        return forsikringsbelop;
    }

    public LocalDate getOpprettetDato() {
        return opprettetDato;
    }
}
