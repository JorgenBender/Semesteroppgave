package org.openjfx;

import java.time.LocalDate;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Forsikring {

    private DateTimeFormatter mittFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private int arligPremie;
    private int forsikringsbelop;
    private LocalDate opprettetDato;

    public Forsikring(int arligPremie, int forsikringsbelop, String dato) {
        this.arligPremie = arligPremie;
        this.forsikringsbelop = forsikringsbelop;
        this.opprettetDato = LocalDate.parse(dato, mittFormat);
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
