package org.openjfx;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Kunderegister {

    private static ArrayList<Kunde> kundeliste = new ArrayList<>(); // FXCollections.observableArrayList();


    public static void nyKunde(Kunde kunde){
        kundeliste.add(kunde);
    }

    public static ArrayList<Kunde> getKundeliste(){
        return kundeliste;
    }

    public static void setKundeliste(ArrayList<Kunde> enKundeliste){
        kundeliste = enKundeliste;
    }

    @Override
    public String toString(){
        String out = "";
        for(Kunde kunde : kundeliste){
            out += kunde + "\n";
        }
        return out;
    }


    //public Kunderegister() { kundeliste.addListener(new InvalidationListener() { @Override public void invalidated(Observable observable) { KunderegisterIO.exporterKundeliste(kundeliste());; }});}
}
