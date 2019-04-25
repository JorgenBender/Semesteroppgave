package org.openjfx;


import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class Kunderegister implements Serializable {

    private ObservableList<Kunde> kundeliste = FXCollections.observableArrayList();

    public Kunderegister() {
        kundeliste.addListener(new InvalidationListener() { @Override public void invalidated(Observable observable) {

        //KunderegisterIO.skrivKundeRegisterTilFil();

        }});
    }

    public void nyKunde(Kunde kunde){
        kundeliste.add(kunde);
    }

    public ObservableList<Kunde> getKundeliste(){
        return kundeliste;
    }

    public void setKundeliste(ObservableList<Kunde> kundeliste){
        this.kundeliste = kundeliste;
    }
}
