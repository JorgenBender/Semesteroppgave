package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;  // import the LocalDate class


public class Forsikring implements Serializable{

    private int arligPremie;
    private int forsikringsbelop;
    private LocalDate opprettetDato;
    private String betingelser;

    public Forsikring(int arligPremie, int forsikringsbelop, LocalDate opprettetDato, String betingelser) {
        this.arligPremie = arligPremie;
        this.forsikringsbelop = forsikringsbelop;
        this.opprettetDato = opprettetDato;
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

    public String getBetingelser() {
        return betingelser;
    }

    public void setArligPremie(int arligPremie) {
        this.arligPremie = arligPremie;
    }

    public void setForsikringsbelop(int forsikringsbelop) {
        this.forsikringsbelop = forsikringsbelop;
    }

    public void setOpprettetDato(LocalDate opprettetDato) {
        this.opprettetDato = opprettetDato;
    }

    public void setBetingelser(String betingelser) {
        this.betingelser = betingelser;
    }

    @Override
    public String toString(){
        return String.format("Årlig Premie: %d\nForsikringsbeløp: %d\nOpprettet dato: %s\nBetingelser: %s",
                            getArligPremie(),getForsikringsbelop(),getOpprettetDato().toString(),getBetingelser());
    }
    public String toCsv(){
        return String.format("%d;%d;%s;%s",
                getArligPremie(),getForsikringsbelop(),getOpprettetDato().toString(),getBetingelser());
    }

}
